package com.example.medicalhelp.controller;

import com.example.medicalhelp.model.DoctorModel;
import com.example.medicalhelp.repository.DoctorRepository;
import com.example.medicalhelp.repository.SlotRepository;
import com.example.medicalhelp.utils.AuthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    SlotRepository slotRepository;
    AuthChecker authChecker = new AuthChecker();
    @GetMapping("/admin")
    public String admin(Model model) {
        if(!"admin".equals(authChecker.getPatient().getUsername()))
            return "redirect:/";
        model.addAttribute("doctorForm", new DoctorModel());
        model.addAttribute("auth", authChecker.getAuth());
        model.addAttribute("doctorList", doctorRepository.findAll());
        return "admin";
    }
    @PostMapping("/admin/delete")
    public String deleteDoctor(@RequestParam(required = true, defaultValue = "") Long doctorId) {
        slotRepository.deleteAllByDoctorId(doctorId);
        doctorRepository.deleteById(doctorId);
        return "redirect:/admin";
    }
    @PostMapping("/admin/add")
    public String takeSlot(@ModelAttribute("doctorForm") DoctorModel doctorForm) {
        doctorRepository.save(doctorForm);
        return "redirect:/admin";
    }
}
