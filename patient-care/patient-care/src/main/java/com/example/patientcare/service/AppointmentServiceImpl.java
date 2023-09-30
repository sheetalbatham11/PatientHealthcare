package com.example.patientcare.service;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.Doctor;
import com.example.patientcare.entity.Patient;
import com.example.patientcare.repository.AppointmentRepository;
import com.example.patientcare.repository.DoctorRepository;
import com.example.patientcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment scheduleAppointment(Appointment appointment) {
        Optional<Patient> patient = patientRepository.findById(appointment.getPatient().getId());
        Optional<Doctor> doctor = doctorRepository.findById(appointment.getDoctor().getId());
        if (patient.isPresent() && doctor.isPresent()) {
            appointment.setPatient(patient.get());
            appointment.setDoctor(doctor.get());
            appointment.setAppointmentDateTime(LocalDateTime.now());
            return appointmentRepository.save(appointment);
        } else return null;
    }

    @Override
    public Appointment updateAppointment(long id, Appointment updatedAppointment) {
        if (appointmentRepository.findById(id).isPresent()) {
            Appointment currentAppointment = appointmentRepository.findById(id).get();
            currentAppointment.setPatient(updatedAppointment.getPatient());
            currentAppointment.setDoctor(updatedAppointment.getDoctor());
            currentAppointment.setAppointmentDateTime(updatedAppointment.getAppointmentDateTime());
            currentAppointment.setReason(updatedAppointment.getReason());
            return appointmentRepository.save(currentAppointment);
        } else return null;
    }

    @Override
    public boolean cancelAppointment(long id) {
        if (appointmentRepository.findById(id).isPresent()) {
            appointmentRepository.deleteById(id);
            return true;
        } else return false;
    }
}