package org.goldenalf.springcourse.controllers;//package org.goldenalf.springcourse.controllers;
//
//import org.goldenalf.springcourse.dao.PersonsDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller()
//@RequestMapping("/test-batch-update")
//public class BatchUpdateController {
//    PersonsDAO personsDAO;
//
//    @Autowired
//    public BatchUpdateController(PersonsDAO personsDAO) {
//        this.personsDAO = personsDAO;
//    }
//
//    @GetMapping()
//    public String index(){
//        return "batch/index";
//    }
//
//    @GetMapping("/without")
//    public String without() {
//        personsDAO.testMultiplyUpdate();
//        return "redirect:/people";
//    }
//
//    @GetMapping("/with")
//    public String with() {
//        personsDAO.testBatchUpdate();
//        return "redirect:/people";
//    }
//}
