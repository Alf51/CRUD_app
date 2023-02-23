package org.goldenalf.springcourse.controlers;

import jakarta.validation.Valid;
import org.goldenalf.springcourse.dao.PersonsDAO;
import org.goldenalf.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonsDAO personsDAO;

    @Autowired
    public PeopleController(PersonsDAO personsDAO) {
        this.personsDAO = personsDAO;
    }

    @GetMapping({"/", ""})
    public String index(Model model) {
        //dao возвращает список всех людей
        model.addAttribute("people", personsDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //dao возвращает конкретного персонажа
        model.addAttribute("person", personsDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPersonCreate(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personsDAO.addPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personsDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personsDAO.update(id, person);
        return "redirect:/people";
    }

    //принял вызов, выташил id в переменную и удали из базы
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personsDAO.delete(id);
        return "redirect:/people";
    }
}
