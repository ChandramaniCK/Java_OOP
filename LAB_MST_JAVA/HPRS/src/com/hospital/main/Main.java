package com.hospital.main;

import java.util.Scanner;
import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;
import com.hospital.exception.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalService hs = new HospitalService();

        try {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            if(age < 0 || age > 120)
                throw new InvalidAgeException("Invalid Age");

            System.out.print("Enter Disease: ");
            String disease = sc.nextLine();

            Patient p = new Patient(id,name,age,disease);

            hs.addPatient(p);

            System.out.println("\nAll Patients:");
            hs.displayPatients();

            System.out.print("\nEnter ID to Search: ");
            int sid = sc.nextInt();

            hs.searchPatient(sid);

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}