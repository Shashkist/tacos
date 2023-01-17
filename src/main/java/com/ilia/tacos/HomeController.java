package com.ilia.tacos;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
    @Controller
    public class HomeController {
        @GetMapping("/")
        public String home() {
            System.out.println("rry4353r");
            System.out.println("gdgdg");
            return "home";
        }
}
