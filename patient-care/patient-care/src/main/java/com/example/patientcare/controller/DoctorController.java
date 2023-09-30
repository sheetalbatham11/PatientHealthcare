package com.example.patientcare.controller;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.entity.Doctor;
import com.example.patientcare.service.AppointmentService;
import com.example.patientcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    private AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor addedDoctor = doctorService.addDoctor(doctor);
        if (addedDoctor != null)
            return new ResponseEntity<>(addedDoctor, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) {
        Doctor updatedDoctor = doctorService.updateDoctorProfile(id, doctor);
        if (updatedDoctor != null)
            return new ResponseEntity<>(updatedDoctor, HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null)
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/{id}/doctor")
//    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable("id") Long id) {
//        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(id);
//        if (appointments != null)
//            return new ResponseEntity<>(appointments, HttpStatus.OK);
//        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") long id) {
        System.out.println("in deleteDoctor");
        boolean deletedDoctor = doctorService.deleteDoctor(id);
        if (deletedDoctor)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
