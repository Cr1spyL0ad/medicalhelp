package com.example.medicalhelp.utils;

import com.example.medicalhelp.model.DoctorModel;
import com.example.medicalhelp.model.PatientModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthChecker {
    public String getAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_PATIENT"))) {
            return "PATIENT";
        } else if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_DOCTOR"))) {
            return "DOCTOR";
        }
        return "ANONYMOUS";
    }

    public PatientModel getPatient() {
        return (PatientModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public DoctorModel getDoctor() {
        return (DoctorModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
