package com.hospital.patient;

public class Patient {

    int patientId;
    String patientName;
    int age;
    String disease;

    public Patient(int patientId, String patientName, int age, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
    }

    public void displayPatient() {
        System.out.println(patientId + " " + patientName + " " + age + " " + disease);
    }
}