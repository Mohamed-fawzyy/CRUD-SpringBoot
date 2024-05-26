package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.Nonnull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Nonnull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getllAllPeople();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
        return personService.selectPersonById(id);
    }

    @DeleteMapping(params = "id")
    public void deletePersonById(@RequestParam("id") UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping
    public void updatePersonById(@RequestParam("id") UUID id, @Nonnull @RequestBody Person person){
        personService.updatePersonById(id, person);
    }
}
