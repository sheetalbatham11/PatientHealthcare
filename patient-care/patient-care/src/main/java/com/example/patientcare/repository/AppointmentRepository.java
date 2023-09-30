package com.example.patientcare.repository;

import com.example.patientcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctor_id);
    List<Appointment> findByPatientId(Long patient_id);
}
