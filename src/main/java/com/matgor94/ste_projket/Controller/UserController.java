package com.matgor94.ste_projket.Controller;

import com.matgor94.ste_projket.Domain.Repository.UserRepository;
import com.matgor94.ste_projket.Domain.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/saldo")
    public String showSaldo(Model model, Long id){
        model.addAttribute("user", userService.getUser(1L));
        return "saldo";
    }
}
