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
        personList.add(new Person(++COUNT_ID, "Петька"));
        personList.add(new Person(++COUNT_ID, "Greench"));
        personList.add(new Person(++COUNT_ID, "Марина"));
        personList.add(new Person(++COUNT_ID, "Стас"));
        personList.add(new Person(++COUNT_ID, "Кевин"));
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
        personToBeUpdated.setName(personUpdate.getName());
    }

    public void delete(int id) {
        personList.removeIf(e -> e.getId() == id);
    }
}
