package com.example.medicalhelp.service;

import com.example.medicalhelp.model.PatientModel;
import com.example.medicalhelp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements UserDetailsService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PatientModel patient = patientRepository.findByUsername(username);
        if (patient == null) {
            throw new UsernameNotFoundException("Patient not found");
        }
        return patient;
    }

    public boolean saveUser(PatientModel user) {
        PatientModel userFromDb = patientRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setAge();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        patientRepository.save(user);
        return true;

    }
}
