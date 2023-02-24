package org.goldenalf.springcourse.dao;

import org.goldenalf.springcourse.model.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonsDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "456789";
    private static int COUNT = 12;

    Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(USER_NAME);
            System.out.println(URL);
            System.out.println(PASSWORD);
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> personList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }

    public Person show(int id) {
        //return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = String.format("INSERT INTO person VALUES (%d, '%s', '%d', '%s')",
                    ++COUNT, person.getName(), person.getAge(), person.getEmail());
            System.out.println("мой запрос = " + SQL);
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person personUpdate) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setAge(personUpdate.getAge());
        personToBeUpdated.setEmail(personUpdate.getEmail());
        personToBeUpdated.setName(personUpdate.getName());
    }

    public void delete(int id) {
//        personList.removeIf(e -> e.getId() == id);
    }
}
