package org.goldenalf.springcourse.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondControler {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
