package com.example.patientcare.controller;

import com.example.patientcare.entity.Appointment;
import com.example.patientcare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/save")
    public ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment) {
        Appointment addedAppointment = appointmentService.scheduleAppointment(appointment);
        if (addedAppointment != null)
            return new ResponseEntity<>(addedAppointment, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") Long id, Appointment appointment) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointment);
        if (updatedAppointment != null)
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null)
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/{id}/doctor")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable("id") Long doctorId) {
        List<Appointment> doctorAppointments = appointmentService.getAppointmentsByDoctorId(doctorId);
        if (doctorAppointments != null)
            return new ResponseEntity<>(doctorAppointments, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/{id}/patient")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable("id") Long patientId) {
        List<Appointment> patientAppointments = appointmentService.getAppointmentsByPatientId(patientId);
        if (patientAppointments != null)
            return new ResponseEntity<>(patientAppointments, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable("id") Long id) {
        boolean deletedAppointment = appointmentService.cancelAppointment(id);
        if (deletedAppointment)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
