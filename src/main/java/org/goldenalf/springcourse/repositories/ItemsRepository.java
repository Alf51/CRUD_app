package org.goldenalf.springcourse.repositories;

import org.goldenalf.springcourse.model.Item;
import org.goldenalf.springcourse.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String name);
    List<Item> findByPerson(Person person);
}
