package org.goldenalf.springcourse.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstControler {

    @GetMapping("/hello")
    public String sayHellow() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "first/goodbye";
    }
}
