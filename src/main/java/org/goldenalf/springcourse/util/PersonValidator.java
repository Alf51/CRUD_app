package org.goldenalf.springcourse.util;

import org.goldenalf.springcourse.dao.PersonsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import org.goldenalf.springcourse.model.Person;

import java.util.List;

@Component
public class PersonValidator implements Validator {
    private final PersonsDAO personsDAO;

    @Autowired
    public PersonValidator(PersonsDAO personsDAO) {
        this.personsDAO = personsDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        //посмотреть есть ли человек с таким же email в БД
        if (personsDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "Данный email уже используется");
        }
    }
}
