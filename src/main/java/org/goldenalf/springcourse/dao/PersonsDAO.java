package org.goldenalf.springcourse.dao;

import org.goldenalf.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        //Для генерации ID
        int maxId = index().stream().mapToInt(Person::getId).max().orElse(1);

        jdbcTemplate.update("INSERT INTO person VALUES (?, ?, ?, ?)",
                ++maxId, person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person personUpdate) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                personUpdate.getName(),
                personUpdate.getAge(),
                personUpdate.getEmail(),
                id);

    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
