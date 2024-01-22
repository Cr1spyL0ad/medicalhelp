package com.example.medicalhelp.controller;

import com.example.medicalhelp.repository.SlotRepository;
import com.example.medicalhelp.service.SlotService;
import com.example.medicalhelp.utils.AuthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ProfileController {
    AuthChecker authChecker = new AuthChecker();
    @Autowired
    SlotService slotService;
    @Autowired
    SlotRepository slotRepository;
    @GetMapping("/profile")
    public String productInfo(Model model) {
        if (authChecker.getAuth().equals("ANONYMOUS")) {
            return "redirect:/";
        }
        if (slotRepository.findAllByPatientIdAndTimeAfter(authChecker.getPatient().getId(), LocalDateTime.now()).isEmpty()) {
            return "redirect:/noSlots";
        }
        model.addAttribute("auth", authChecker.getAuth());
        model.addAttribute("table", slotService.getUserSlots(slotRepository.findAllByPatientIdAndTimeAfter(authChecker.getPatient().getId(), LocalDateTime.now())));
        return "profile";
    }
    @PostMapping("/profile/deleteSlot")
    public String deleteSlot(@RequestParam(defaultValue = "") Long slotId) {
        slotRepository.deleteById(slotId);
        return "redirect:/profile";
    }
}