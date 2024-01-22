package com.example.medicalhelp.service;

import com.example.medicalhelp.model.DoctorModel;
import com.example.medicalhelp.model.PatientModel;
import com.example.medicalhelp.model.SlotModel;
import com.example.medicalhelp.repository.DoctorRepository;
import com.example.medicalhelp.repository.SlotRepository;
import com.example.medicalhelp.utils.AuthChecker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {
    @Autowired
    SlotRepository slotRepository;
    @Autowired
    DoctorRepository doctorRepository;
    AuthChecker authChecker = new AuthChecker();
    public LocalDate getMinimumDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate minimumDate;
        if(currentDate.getDayOfWeek() == DayOfWeek.FRIDAY)
            minimumDate = currentDate.plusDays(3);
        else if(currentDate.getDayOfWeek() == DayOfWeek.SATURDAY)
            minimumDate = currentDate.plusDays(2);
        else
            minimumDate = currentDate.plusDays(1);
        return minimumDate;
    }

    public LocalDate getMaximumDate(LocalDate minimumDate) {
        LocalDate maximumDate;
        maximumDate = minimumDate.plusDays(4 - minimumDate.getDayOfWeek().ordinal());
        return maximumDate;
    }

    public boolean saveSlot(SlotModel slotForm) {
        slotForm.setTime(LocalDateTime.of(slotForm.getUnfinishedDate(), LocalTime.parse(slotForm.getUnfinishedTime(), DateTimeFormatter.ofPattern("HH:mm:ss"))));
        slotForm.setPatientId(authChecker.getPatient().getId());
        slotRepository.save(slotForm);
        return true;
    }

    public List<String> getFreeSlots(Long doctorId, LocalDate unfinishedDate) {
        List<String> freeTimeList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        List<SlotModel> occupiedSlotsList = slotRepository.findAllByTimeBetweenAndDoctorId(unfinishedDate.atTime(5, 0, 0), unfinishedDate.atTime(20, 00, 00), doctorId);
        List<LocalDateTime> occupiedTimeList = occupiedSlotsList.stream().map(SlotModel::getTime).toList();
        LocalDateTime startingTime = unfinishedDate.atTime(9, 0,0);
        while (startingTime.getHour() < 17) {
            if(!occupiedTimeList.contains(startingTime)) {
                freeTimeList.add(startingTime.format(dateTimeFormatter));
            }
           startingTime = startingTime.plusMinutes(30);
        }
        return freeTimeList;
    }

    public List<SlotModel.SlotTable> getUserSlots(List<SlotModel> slotList) {
        List<SlotModel.SlotTable> tableList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        for( SlotModel slot: slotList) {
            DoctorModel doctor = doctorRepository.findFirstById(slot.getDoctorId());
            SlotModel.SlotTable slotTable = new SlotModel.SlotTable();
            slotTable.setTime(slot.getTime().format(dateTimeFormatter));
            slotTable.setSlotId(slot.getId());
            slotTable.setName(doctor.getName());
            slotTable.setCabinet(doctor.getCabinetNumber());
            tableList.add(slotTable);
        }
        return tableList;
    }

}
