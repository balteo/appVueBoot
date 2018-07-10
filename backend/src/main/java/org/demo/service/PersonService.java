package org.demo.service;

import org.demo.domain.Person;
import org.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons() {
        return this.personRepository.findAll();
    }

    public Optional<Person> findPersonById(String id) {
        return this.personRepository.findById(id);
    }
}
