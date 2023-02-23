package org.goldenalf.springcourse.dao;

import org.goldenalf.springcourse.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonsDAO {
    private int COUNT_ID;

    private final List<Person> personList = new ArrayList<>();

    {
        personList.add(new Person(++COUNT_ID, "Петька", 41, "petka@gmail.com"));
        personList.add(new Person(++COUNT_ID, "Greench", 21, "move@gmail.com"));
        personList.add(new Person(++COUNT_ID, "Марина", 31, "seled@gmail.com"));
        personList.add(new Person(++COUNT_ID, "Стас", 47, "kvaka@gmail.com"));
        personList.add(new Person(++COUNT_ID, "Кевин", 19, "kurtka@gmail.com"));
    }

    public List<Person> index() {
        return new ArrayList<>(personList);
    }

    public Person show(int id) {
        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void addPerson(Person person) {
        person.setId(++COUNT_ID);
        personList.add(person);
    }

    public void update(int id, Person personUpdate) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setAge(personUpdate.getAge());
        personToBeUpdated.setEmail(personUpdate.getEmail());
        personToBeUpdated.setName(personUpdate.getName());
    }

    public void delete(int id) {
        personList.removeIf(e -> e.getId() == id);
    }
}
