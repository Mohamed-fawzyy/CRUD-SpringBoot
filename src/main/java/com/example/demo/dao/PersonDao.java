package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    void insertPerson(UUID id, Person person); // to add person with id

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    void deletePersonById(UUID id);

    void updatePersonById(UUID id, Person person);

    default void insertPerson(Person person) { // to add person without having id
        insertPerson(UUID.randomUUID(), person);
    }
}
