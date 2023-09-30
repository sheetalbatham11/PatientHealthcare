package com.example.patientcare.controller;

import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.service.EHRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ehrs")
public class EHRController {

    @Autowired
    private EHRService ehrService;

    @PostMapping("/save")
    public ResponseEntity<ElectronicHealthRecords> addEHR(@RequestBody ElectronicHealthRecords ehr) {
        ElectronicHealthRecords addedEHR = ehrService.createEHR(ehr);
        if (addedEHR != null)
            return new ResponseEntity<>(addedEHR, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ElectronicHealthRecords> updateEHR(@PathVariable("id") Long id, @RequestBody ElectronicHealthRecords updateEHR) {
        ElectronicHealthRecords updatedEHR = ehrService.updateEHR(id, updateEHR);
        if (updatedEHR != null)
            return new ResponseEntity<>(updatedEHR, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/get/{id}/ehr")
    public ResponseEntity<List<ElectronicHealthRecords>> getEHRByPatientId(@PathVariable("id") Long patientId) {
        List<ElectronicHealthRecords> records = ehrService.getEHRByPatientId(patientId);
        if (records != null)
            return new ResponseEntity<>(records, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/get/{id}")
    public ResponseEntity<ElectronicHealthRecords> getEHRById(@PathVariable("id") Long id) {
        ElectronicHealthRecords ehr = ehrService.getEHRById(id);
        if (ehr != null)
            return new ResponseEntity<>(ehr, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEHR(@PathVariable("id") Long id) {
        boolean deletedEHR = ehrService.deleteEHR(id);
        if (deletedEHR)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
