package com.example.demo.container;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
