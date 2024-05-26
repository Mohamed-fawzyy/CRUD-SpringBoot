package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public void addPerson(Person person) {
        personDao.insertPerson(person);
    }

    public List<Person> getllAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> selectPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public void deletePersonById(UUID id){
        personDao.deletePersonById(id);
    }

    public void updatePersonById(UUID id, Person person){
        personDao.updatePersonById(id, person);
    }
}
