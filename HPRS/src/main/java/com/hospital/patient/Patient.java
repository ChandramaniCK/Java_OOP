package com.hospital.patient;

public class Patient {
    private int patientId;
    private String patientName;
    private int age;
    private String disease;

    public Patient(int patientId, String patientName, int age, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
    }

    public int getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getDisease() { return disease; }

    public String toFileString() {
        return patientId + "," + patientName + "," + age + "," + disease;
    }
}