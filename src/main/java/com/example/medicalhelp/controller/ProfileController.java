package com.example.medicalhelp.controller;

import com.example.medicalhelp.utils.AuthChecker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
    AuthChecker authChecker = new AuthChecker();

    @GetMapping("/profile")
    public String productInfo(Model model) {
        model.addAttribute("auth", authChecker.getAuth());
        model.addAttribute("user", authChecker.getPatient());
        return "profile";
    }
}