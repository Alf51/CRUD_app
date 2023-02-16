package org.goldenalf.springcourse.dao;

import org.goldenalf.springcourse.model.People;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private int COUNT_ID;
    private List<People> peopleList = new ArrayList<>();

    {
        peopleList.add(new People(++COUNT_ID, "Петька"));
        peopleList.add(new People(++COUNT_ID, "Greench"));
        peopleList.add(new People(++COUNT_ID, "Марина"));
        peopleList.add(new People(++COUNT_ID, "Стас"));
        peopleList.add(new People(++COUNT_ID, "Кевин"));
    }

    public List<People> index() {
        return new ArrayList<>(peopleList);
    }

    public People show(int id) {
        return peopleList.stream().filter(people -> people.getId() == id).findAny().orElse(null);
    }
}
