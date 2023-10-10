package org.goldenalf.springcourse.services;

import org.goldenalf.springcourse.model.Item;
import org.goldenalf.springcourse.model.Person;
import org.goldenalf.springcourse.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByName(String name) {
        return itemsRepository.findByName(name);
    }

    public List<Item> findByPerson(Person person) {
        return itemsRepository.findByPerson(person);
    }
}
