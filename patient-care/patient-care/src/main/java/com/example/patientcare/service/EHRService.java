package com.example.patientcare.service;

import com.example.patientcare.entity.ElectronicHealthRecords;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EHRService {
    
    ElectronicHealthRecords createEHR(ElectronicHealthRecords eHR);

    ElectronicHealthRecords updateEHR(long id, ElectronicHealthRecords updatedEHR);

    List<ElectronicHealthRecords> getEHRByPatientId(Long patient_id);

    ElectronicHealthRecords getEHRById(Long id);
    
    boolean deleteEHR (long id);
}
