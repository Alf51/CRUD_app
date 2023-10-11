package org.goldenalf.springcourse.util;

import org.goldenalf.springcourse.model.Person;
import org.goldenalf.springcourse.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService personsDAO) {
        this.peopleService = personsDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        //посмотреть есть ли человек с таким же email в БД
        if (peopleService.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "Данный email уже используется");
        }

    }
}
