//package org.goldenalf.springcourse.controlers;
//
//import org.goldenalf.springcourse.dao.PeopleDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/people")
//public class PeopleController {
//    private final PeopleDAO peopleDAO;
//
//    @Autowired
//    public PeopleController(PeopleDAO peopleDAO) {
//        this.peopleDAO = peopleDAO;
//    }
//
//    @GetMapping()
//    public String index(Model model) {
//        //dao возвращает список всех людей
//        model.addAttribute("people", peopleDAO.index());
//        return "people/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        //dao возвращает список всех людей
//        System.out.println(peopleDAO.show(id).getName());
//        model.addAttribute("person", peopleDAO.show(id));
//        return "people/show";
//    }
//}
