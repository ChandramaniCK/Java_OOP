package com.hospital.service;

import com.hospital.patient.Patient;
import com.hospital.exception.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.*;

public class HospitalService {

    private static final String FILE_NAME = "patients.txt";

    public void addPatient(Patient p) throws Exception {

        if (p.getAge() < 0 || p.getAge() > 120) {
            throw new InvalidAgeException("Invalid Age!");
        }

        if (isDuplicate(p.getPatientId())) {
            throw new DuplicatePatientException("Patient ID already exists!");
        }

        // ✅ Save to file
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
        bw.write(p.toFileString());
        bw.newLine();
        bw.close();

        // ✅ Save to DB (JDBC)
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO patients VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, p.getPatientId());
        ps.setString(2, p.getPatientName());
        ps.setInt(3, p.getAge());
        ps.setString(4, p.getDisease());

        ps.executeUpdate();
        con.close();

        // ✅ Priority check
        if (p.getAge() > 60 && p.getDisease().equalsIgnoreCase("Heart Problem")) {
            System.out.println("⚠ Priority Patient – Immediate Attention Required");
        }
    }

    // 🗑️ DELETE PATIENT
    public void deletePatient(int id) throws Exception {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (Integer.parseInt(data[0]) == id) {
                found = true;
                continue; // skip deleting line
            }
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (!found) {
            throw new PatientNotFoundException("Patient not found!");
        }
    }

    // 🔍 SEARCH PATIENT
    public String searchPatient(int id) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (Integer.parseInt(data[0]) == id) {
                br.close();
                return line;
            }
        }

        br.close();
        throw new PatientNotFoundException("Patient not found!");
    }


    private boolean isDuplicate(int id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.split(",")[0].equals(String.valueOf(id))) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    public String getAllPatients() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("<br>");
        }
        br.close();
        return sb.toString();
    }
}