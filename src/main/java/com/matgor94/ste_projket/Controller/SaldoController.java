package com.matgor94.ste_projket.Controller;

import com.matgor94.ste_projket.Domain.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SaldoController {
    private final UserService userService;

    public SaldoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/saldo")
    public String showSaldo(Model model, Long id){
        model.addAttribute("imie", userService.getUser(id).getFirstName());
        model.addAttribute("saldo", userService.getUser(id).getSaldo());
        return "saldo";
    }
}
