package org.goldenalf.springcourse.dao;

import org.goldenalf.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Person> show(String email) {
        return jdbcTemplate.query("SELECT * FROM person WHERE email=?", new BeanPropertyRowMapper<>(Person.class), email)
                .stream().findAny();
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, age, email) VALUES (?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail());
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

    ///////
    //Test batch update
    //////

    public void testMultiplyUpdate() {
        List<Person> personList1000 = createPeoples();

        long startProgramTime = System.currentTimeMillis();
        personList1000.forEach(this::save);
        System.out.printf("Execution time %d seconds", (System.currentTimeMillis() - startProgramTime) / 1000);
    }

    private List<Person> createPeoples() {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            Person person = new Person();
            person.setName("Name" + i);
            person.setAge(10 + i);
            person.setEmail("test" + i + "@mail.ru");

            personList.add(person);
        }
        return personList;
    }

    public void testBatchUpdate() {
        List<Person> personList = createPeoples();

        long startProgramTime = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES (?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, 20);
                preparedStatement.setString(2, personList.get(i).getName());
                preparedStatement.setInt(3, personList.get(i).getAge());
                preparedStatement.setString(4, personList.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return personList.size();
            }
        });
        System.out.printf("Execution time %d seconds", (System.currentTimeMillis() - startProgramTime) / 1000);
    }
}
