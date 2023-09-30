package com.example.patientcare.service;

import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.repository.EHRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EHRServiceImpl implements EHRService {

    @Autowired
    private EHRRepository ehrRepository;

    @Override
    public ElectronicHealthRecords createEHR(ElectronicHealthRecords ehr) {
        return ehrRepository.save(ehr);
    }

    @Override
    public ElectronicHealthRecords updateEHR(long id, ElectronicHealthRecords updatedEHR) {
        if (ehrRepository.findById(id).isPresent()) {
            ElectronicHealthRecords currentEHR = ehrRepository.findById(id).get();
            currentEHR.setPatient(updatedEHR.getPatient());
            currentEHR.setDoctor(updatedEHR.getDoctor());
            currentEHR.setDiagnosis(updatedEHR.getDiagnosis());
            currentEHR.setTreatment(updatedEHR.getTreatment());
            currentEHR.setDateRecorded(updatedEHR.getDateRecorded());
            return ehrRepository.save(updatedEHR);
        } else return null;
    }

    @Override
    public List<ElectronicHealthRecords> getEHRByPatientId(Long patientId) {
        return ehrRepository.findByPatientId(patientId);
    }

    @Override
    public ElectronicHealthRecords getEHRById(Long id) {
        return ehrRepository.findById(id).get();
    }

    @Override
    public boolean deleteEHR(long id) {
        if (ehrRepository.findById(id).isPresent()) {
            ehrRepository.deleteById(id);
            return true;
        } else return false;
    }
}
