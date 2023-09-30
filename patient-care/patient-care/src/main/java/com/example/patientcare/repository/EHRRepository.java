package com.example.patientcare.repository;

import com.example.patientcare.entity.ElectronicHealthRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EHRRepository extends JpaRepository<ElectronicHealthRecords, Long> {
    List<ElectronicHealthRecords> findByPatientId(Long patient_id);
}
