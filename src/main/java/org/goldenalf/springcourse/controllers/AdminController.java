package org.goldenalf.springcourse.controllers;

import org.goldenalf.springcourse.dao.PersonsDAO;
import org.goldenalf.springcourse.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonsDAO personsDAO;

    @Autowired
    public AdminController(PersonsDAO personsDAO) {
        this.personsDAO = personsDAO;
    }

    @GetMapping("/")
    public String adminPage(Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", personsDAO.index());

        return "adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person) {
        System.out.println(person.getId());
        return "redirect:/people";
    }
}
