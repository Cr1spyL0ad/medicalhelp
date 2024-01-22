package com.example.medicalhelp.controller;

import com.example.medicalhelp.model.PatientModel;
import com.example.medicalhelp.service.PatientService;
import com.example.medicalhelp.utils.AuthChecker;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private PatientService patientService;
    AuthChecker util = new AuthChecker();

    @GetMapping("/registration")
    public String authCheck(Model model) {
        model.addAttribute("userForm", new PatientModel());
        model.addAttribute("auth", util.getAuth());
        if (!util.getAuth().equals("ANONYMOUS")) {
            return "redirect:/";
        }
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid PatientModel userForm, Model model) {
        model.addAttribute("auth", util.getAuth());
        if (!userForm.getPassword().equals(userForm.getConfirmedPassword())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!patientService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/login";
    }
}
