package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static final List<Person> DB = new ArrayList<>();

    @Override
    public void insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public void deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        personMaybe.ifPresent(DB::remove);
        System.out.println("Deleted person: " + id);
        /*
            if (personMaybe.isPresent()) {
            DB.remove(personMaybe.get());
        }
        */
    }

    @Override
    public void updatePersonById(UUID id, Person person) {
//        selectPersonById(id)
//                .map(p -> {
//                    int index = DB.indexOf(p);
//                    if (index != -1) {
//                        DB.set(index, person);
//                    }
//                    return 0;
//                });
//        System.out.println("not found");

        selectPersonById(id).ifPresentOrElse(
                p -> {
                    int index = DB.indexOf(p);
                    if (index != -1) {
                        DB.set(index, new Person(id, person.getName()));
                    }
                },
                () -> System.out.println("Person with id " + id + " not found.")
        );
    }

}
