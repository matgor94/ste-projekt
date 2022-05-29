package com.matgor94.ste_projket.Controller;

import com.matgor94.ste_projket.Domain.Repository.UserRepository;
import com.matgor94.ste_projket.Domain.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/saldo")
    public String showSaldo(Model model, Long id){
        model.addAttribute("user", userRepository.findById(id));
        return "saldo";
    }
}
