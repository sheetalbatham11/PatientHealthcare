package com.example.patientcare.service;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.entity.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    List<ElectronicHealthRecords> getEHRById(Long id);

    List<Appointment> getAppointmentsByPatientId(Long id);

    Patient addPatient(Patient patient);

    Patient updatePatient(long id, Patient updatedPatient);

    boolean deletePatient(long id);
}
