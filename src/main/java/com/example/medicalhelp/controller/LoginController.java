package com.example.medicalhelp.controller;

import com.example.medicalhelp.utils.AuthChecker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    AuthChecker authChecker = new AuthChecker();

    @GetMapping("/login")
    public String authCheck(Model model) {
        model.addAttribute("auth", authChecker.getAuth());
        if (!authChecker.getAuth().equals("ANONYMOUS")) {
            return "redirect:/";
        }
        return "login";
    }
}
