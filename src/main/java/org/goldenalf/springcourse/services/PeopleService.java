package org.goldenalf.springcourse.services;

import org.goldenalf.springcourse.model.Item;
import org.goldenalf.springcourse.model.Mood;
import org.goldenalf.springcourse.model.Person;
import org.goldenalf.springcourse.repositories.PeopleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person) {
        person.setCreatedAt(new Date());
        person.setMood(getRandomMood());
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        updatedPerson.setMood(getRandomMood());
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Person> show(String email) {
        return peopleRepository.findByEmail(email).stream().findAny();
    }

    public List<Person> findByName(String name) {
        return peopleRepository.findByName(name);
    }

    public List<Person> findByNameOrderByAge(String name) {
        return peopleRepository.findByNameOrderByAge(name);
    }

    public List<Person> findByEmail(String email) {
        return peopleRepository.findByEmail(email);
    }

    public List<Person> findByNameStartingWith(String startingWith) {
        return peopleRepository.findByNameStartingWith(startingWith);
    }

    public List<Person> findByNameOrEmail(String name, String email) {
        return peopleRepository.findByNameOrEmail(name, email);
    }

    private Mood getRandomMood() {
        return Mood.values()[new Random().nextInt(Mood.values().length)];
    }
}
