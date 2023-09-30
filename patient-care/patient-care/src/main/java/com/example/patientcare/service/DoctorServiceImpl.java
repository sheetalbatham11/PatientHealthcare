package com.example.patientcare.service;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.Doctor;
import com.example.patientcare.repository.AppointmentRepository;
import com.example.patientcare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long id) {
        return appointmentRepository.findByDoctorId(id);
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctorProfile(Long id, Doctor updatedDoctor) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor thisDoctor = doctorRepository.findById(id).get();
            thisDoctor.setName(updatedDoctor.getName());
            thisDoctor.setGender(updatedDoctor.getGender());
            thisDoctor.setContactNumber(updatedDoctor.getContactNumber());
            thisDoctor.setEmail(updatedDoctor.getEmail());
            thisDoctor.setAddress(updatedDoctor.getAddress());
            thisDoctor.setQualification(updatedDoctor.getQualification());
            thisDoctor.setSpecialization(updatedDoctor.getSpecialization());

            return doctorRepository.save(thisDoctor);
        } else return null;
    }

    @Override
    public boolean deleteDoctor(Long id) {
        if (doctorRepository.findById(id).isPresent()) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
