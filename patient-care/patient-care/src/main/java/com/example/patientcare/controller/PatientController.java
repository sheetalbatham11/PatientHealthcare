package com.example.patientcare.controller;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.ElectronicHealthRecords;
import com.example.patientcare.entity.Patient;
import com.example.patientcare.service.AppointmentService;
import com.example.patientcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        System.out.println("in addPatient");
        Patient addedPatient = patientService.addPatient(patient);
        if (addedPatient != null) {
            return new ResponseEntity<>(addedPatient, HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestParam(name = "id") long id, @RequestBody Patient updatePatient) {
        System.out.println("in updatePatient");
        Patient updatedPatient = patientService.updatePatient(id, updatePatient);
        if (updatedPatient != null)
            return new ResponseEntity<>(updatedPatient, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null)
            return new ResponseEntity<>(patient, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/{id}/ehr")
//    public ResponseEntity<List<ElectronicHealthRecords>> viewEHR(@PathVariable("id") long id) {
//        List<ElectronicHealthRecords> records = patientService.getEHRById(id);
//        if (records != null)
//            return new ResponseEntity<>(records, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/{id}/patient")
//    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable("id") Long patientId) {
//        List<Appointment> patientAppointments = appointmentService.getAppointmentsByPatientId(patientId);
//        if (patientAppointments != null)
//            return new ResponseEntity<>(patientAppointments, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") long id) {
        System.out.println("in deletePatient");
        boolean deletedPatient = patientService.deletePatient(id);
        if (deletedPatient)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
