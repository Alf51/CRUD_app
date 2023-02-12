package org.goldenalf.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControler {

    @GetMapping("/hello1")
    public String sayHello() {
        return "hello_word";
    }
}
