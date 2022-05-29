package com.matgor94.ste_projket.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public static String loginPage() {
        return "login";
    }
}
