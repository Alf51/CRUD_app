package org.goldenalf.springcourse.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstControler {

    @GetMapping("/hello")
    public String sayHellow(@RequestParam(value = "name", required = false) String name) {
        if (name != null && name.equals("vasily")) {
            return "first/secredPage";
        }
        return "first/hello";
    }

    @GetMapping("/index")
    public String getIndexPage() {
        return "UBEREats/index";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "first/goodbye";
    }
}
