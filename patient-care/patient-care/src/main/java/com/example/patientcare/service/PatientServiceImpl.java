package com.example.patientcare.service;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.entity.Patient;
import com.example.patientcare.repository.AppointmentRepository;
import com.example.patientcare.repository.EHRRepository;
import com.example.patientcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Service
public class PatientServiceImpl implements PatientService, Serializable
{

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EHRRepository ehrRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;


    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<ElectronicHealthRecords> getEHRById(Long patientId) {
        return ehrRepository.findByPatientId(patientId);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public Patient addPatient(Patient patient) {
        Patient addedPatient= patientRepository.save(patient);
        Appointment initialAppointment= new Appointment();
        initialAppointment.setPatient(addedPatient);
        initialAppointment.setAppointmentDateTime(LocalDateTime.now());
        initialAppointment.setReason("Initial Appointment");
        return addedPatient;
    }

    @Override
    public Patient updatePatient(long id, Patient updatedPatient) {
        if (patientRepository.findById(id).isPresent()) {
            Patient currentPatient = patientRepository.findById(id).get();
            currentPatient.setName(updatedPatient.getName());
            currentPatient.setDateOfBirth(updatedPatient.getDateOfBirth());
            currentPatient.setContactNumber(updatedPatient.getContactNumber());
            currentPatient.setAddress(updatedPatient.getAddress());
            return patientRepository.save(currentPatient);
        } else return null;
    }

    @Override
    public boolean deletePatient(long id) {
        if (patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
            return true;
        } else return false;
    }
}
