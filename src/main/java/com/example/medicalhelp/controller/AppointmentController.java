package com.example.medicalhelp.controller;

import com.example.medicalhelp.model.SlotModel;
import com.example.medicalhelp.repository.DoctorRepository;
import com.example.medicalhelp.repository.SlotRepository;
import com.example.medicalhelp.service.SlotService;
import com.example.medicalhelp.utils.AuthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class AppointmentController {
    AuthChecker checker = new AuthChecker();
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    SlotService slotService;
    @Autowired
    SlotRepository slotRepository;
    Boolean noDoctor;

    SlotModel slot = new SlotModel();
    @GetMapping("/appointment")
    public String specializations(Model model) {
        String auth = checker.getAuth();
        if (auth.equals("ANONYMOUS")) {
            return "redirect:/login";
        }
        if (slotRepository.findAllByPatientIdAndTimeAfter(checker.getPatient().getId(), LocalDateTime.now()).size() > 2) {
            return "redirect:/tooManySlots";
        }
        model.addAttribute("noDoctor", noDoctor);
        noDoctor = null;
        model.addAttribute("auth", auth);
        return "specialization";
    }

    @GetMapping("/appointment/{spec}")
    public String slotForm(Model model, @PathVariable String spec) {
        LocalDate minDate = slotService.getMinimumDate();
        String auth = checker.getAuth();
        if (auth.equals("ANONYMOUS")) {
            return "redirect:/login";
        }
        if (slotRepository.findAllByPatientIdAndTimeAfter(checker.getPatient().getId(), LocalDateTime.now()).size() > 2) {
            return "redirect:/tooManySlots";
        }
        else if(doctorRepository.findAllBySpecialization(spec).isEmpty()) {
            noDoctor = true;
            return "redirect:/appointment";
        }
        model.addAttribute("slotForm", slot);
        model.addAttribute("doctorList", doctorRepository.findAllBySpecialization(spec));
        model.addAttribute("minDate", minDate);
        model.addAttribute("maxDate", slotService.getMaximumDate(minDate));
        model.addAttribute("auth", auth);
        return "appointmentForm";
    }
    @PostMapping("/chooseDay")
    public String chooseDay(@ModelAttribute("slotForm") SlotModel slotForm, Model model) {
        slot = slotForm;
        return "redirect:/appointment/schedule";
    }

    @PostMapping("/chooseTime")
    public String takeSlot(@ModelAttribute("slot") SlotModel slotForm, Model model) {
        slotService.saveSlot(slotForm);
        slot.reset();
        return "redirect:/success";
    }


    @GetMapping("/appointment/schedule")
    public String schedule(Model model) {
        String auth = checker.getAuth();
        if (auth.equals("ANONYMOUS")) {
            return "redirect:/login";
        }
        if (slotRepository.findAllByPatientIdAndTimeAfter(checker.getPatient().getId(), LocalDateTime.now()).size() > 2) {
            return "redirect:/tooManySlots";
        }
        if(slot.getDoctorId() == null) {
            return "redirect:/appointment";
        }
        model.addAttribute("slot", slot);
        model.addAttribute("timeList" ,slotService.getFreeSlots(slot.getDoctorId(), slot.getUnfinishedDate()));
        model.addAttribute("auth", auth);
        return "schedule";
    }
}
