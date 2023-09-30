package com.example.patientcare.service;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.entity.Patient;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointmentsByDoctorId(Long id);

    List<Appointment> getAppointmentsByPatientId(Long id);

    Appointment getAppointmentById(Long id);

    Appointment scheduleAppointment(Appointment appointment);

    Appointment updateAppointment(long id, Appointment updatedAppointment);

    boolean cancelAppointment (long id);
}
