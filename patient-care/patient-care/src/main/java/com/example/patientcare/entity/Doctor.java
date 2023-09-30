package com.example.patientcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "doctors")
//@JsonIgnoreProperties("appointments")
public class Doctor implements Serializable {
    //@JsonProperty("doctorId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String gender;
    private String email;
    private String contactNumber;
    private String address;
    private String specialization;
    private String qualification;
    //@JsonIgnore

    @OneToMany(targetEntity = Appointment.class ,mappedBy = "doctor", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonManagedReference
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(long id, String name, String gender, String email, String contactNumber, String address, String specialization, String qualification/*, List<Appointment> appointments*/) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.specialization = specialization;
        this.qualification = qualification;
        /*this.appointments = appointments;*/
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
