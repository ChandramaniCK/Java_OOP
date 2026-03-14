package com.hospital.service;

import java.io.*;
import com.hospital.patient.Patient;
import com.hospital.exception.*;

public class HospitalService {

    String file = "patients.txt";

    public void addPatient(Patient p) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String data[] = line.split(",");
            if (Integer.parseInt(data[0]) == p.patientId) {
                br.close();
                throw new DuplicatePatientException("Duplicate Patient ID");
            }
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(p.patientId + "," + p.patientName + "," + p.age + "," + p.disease);
        bw.newLine();
        bw.close();

        if (p.age > 60 && p.disease.equalsIgnoreCase("Heart Problem")) {
            System.out.println("Priority Patient – Immediate Attention Required");
        }

        System.out.println("Patient Added");
    }

    public void displayPatients() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String data[] = line.split(",");
            System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]);
        }

        br.close();
    }

    public void searchPatient(int id) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String data[] = line.split(",");
            if (Integer.parseInt(data[0]) == id) {
                System.out.println("Patient Found: "+line);
                found = true;
            }
        }

        br.close();

        if (!found)
            throw new PatientNotFoundException("Patient Not Found");
    }
}