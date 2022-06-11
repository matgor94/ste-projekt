package com.matgor94.ste_projket.Controller;

import com.matgor94.ste_projket.Domain.Model.User;
import com.matgor94.ste_projket.Domain.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PrzelewController extends HttpServlet {

    private  final UserService userService;

    public PrzelewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/przelew")
    public String przelew(Model model){
        model.addAttribute("user", userService.getUser(1L));
        return "przelew";
    }

    @PostMapping("/przelew")
    public String przelewWykonaj(Model model, HttpServletRequest request){
        double saldo = userService.getUser(1L).getSaldo();
        String kwotaPrzelewu = request.getParameter("kwotaPrzelewu");
        String komu = request.getParameter("komu");
        double ilePrzelac = Double.parseDouble(kwotaPrzelewu);

        List<User> userList = userService.getListOfUsers();
        List<String> allPhoneNumbers = new ArrayList<>();
        for (User user: userList) {
            allPhoneNumbers.add(user.getPhoneNumber());
        }

        if(ilePrzelac > saldo || ilePrzelac <= 0 ) {
            return "error_kwota";
        }else {
            User adresat = new User();
            for (User user: userList) {
                if(user.getPhoneNumber().equals(komu));
                adresat = user;
            }
            String adresatString = adresat.getFirstName() + " " + adresat.getLastName() + "\n" +adresat.getPesel() +
                    "\n" + adresat.getEmail() + "\n" + adresat.getPhoneNumber();

            User nadawca = userService.getUser(1L);

            String nadawcaString = nadawca.getFirstName() + " " + nadawca.getLastName() + "\n" +
                    nadawca.getPesel() + "\n" +
                    nadawca.getEmail() + "\n" +
                    nadawca.getPhoneNumber();

            model.addAttribute("saldoPoczatek", saldo);
            double saldoNowe = Math.round((saldo - ilePrzelac) * 100) / 100;
            model.addAttribute("saldoNowe", saldoNowe);
            model.addAttribute("ile", ilePrzelac);
            model.addAttribute("nadawca", nadawcaString);
            model.addAttribute("adresat", adresatString);

            nadawca.setSaldo(nadawca.getSaldo() - ilePrzelac);
            userService.addUser(nadawca);
            adresat.setSaldo(adresat.getSaldo() + ilePrzelac);
            userService.addUser(adresat);
        }
            return "przelew_2";
    }

}
