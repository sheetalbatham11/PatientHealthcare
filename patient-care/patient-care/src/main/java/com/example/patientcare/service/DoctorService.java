package com.example.patientcare.service;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.Doctor;
import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.entity.Patient;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    List<Appointment> getAppointmentsByDoctorId(Long id);

    Doctor addDoctor(Doctor doctor);

    Doctor updateDoctorProfile(Long id, Doctor updatedDoctor);

    boolean deleteDoctor(Long id);
}
