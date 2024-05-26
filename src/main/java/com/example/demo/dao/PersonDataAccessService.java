package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertPerson(UUID id, Person person) {

    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "select id, name from person";
        return jdbcTemplate.query(sql, (rs, i) -> {
            UUID id = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            return new Person(id, name);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "select id, name from person where id = ?";
        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, i) -> {
                    UUID personId = UUID.fromString(rs.getString("id"));
                    String name = rs.getString("name");
                    return new Person(personId, name);
                });
        return Optional.ofNullable(person);
    }

    @Override
    public void deletePersonById(UUID id) {

    }

    @Override
    public void updatePersonById(UUID id, Person person) {

    }
}
