package org.goldenalf.springcourse.dao;

import org.goldenalf.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonsDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Person> show(String email) {
        return jdbcTemplate.query("SELECT * FROM person WHERE email=?", new BeanPropertyRowMapper<>(Person.class), email)
                .stream().findAny();
    }
}
