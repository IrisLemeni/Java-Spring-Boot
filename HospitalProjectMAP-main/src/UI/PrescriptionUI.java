package UI;

import Controller.PrescriptionController;
import Domain.HospitalServices.Prescription;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PrescriptionUI extends BaseUI {
    private PrescriptionController controller;

    public PrescriptionUI(PrescriptionController controller) {
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- PRESCRIPTIONS ---------------------------");
            System.out.println("1. Add Prescription");
            System.out.println("2. Remove Prescription");
            System.out.println("3. Add Medication To Prescription");
            System.out.println("4. Set Medication List");
            System.out.println("5. Remove Medication From Prescription");
            System.out.println("6. View All Prescriptions");
            System.out.println("7. Return To The Main Page");
            System.out.println("8. Log Out");

            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    addMedication();
                    break;
                case 4:
                    setMedicationList();
                    break;
                case 5:
                    removeMedication();
                    break;
                case 6:
                    viewAll();
                    break;
                case 7:
                    running = false;
                    break;

                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    @Override
    public void add() {
        System.out.println("----------------------- ADDING PRESCRIPTION -----------------------");
        Scanner scanner = new Scanner(System.in);
        Date date;
        int doctorID;
        int patientID;
        System.out.println("Patient ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateInput);
            controller.add(doctorID,patientID,date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        System.out.println("Patient was added successfully!");
    }
    public void addMedication(){
        System.out.println("----------------------- ADDING MEDICATION TO PRESCRIPTION -----------------------");
        Scanner scanner = new Scanner(System.in);
        int prescriptionID,medicationID;
        System.out.println("Prescription ID: ");
        prescriptionID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Medication ID: ");
        medicationID = scanner.nextInt();
        boolean result = controller.addMedication(prescriptionID,medicationID);
        if(result){
            System.out.println("Update completed");
        }
        else {
            System.out.println("Invalid input values");
            addMedication();
        }


    }
    public void setMedicationList(){
        System.out.println("----------------------- SETTING MEDICATION LIST -----------------------");
        Scanner scanner = new Scanner(System.in);
        int prescriptionID;
        ArrayList<Integer> medicationsID = new ArrayList<>();
        System.out.println("Prescription ID: ");
        prescriptionID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Medications IDs(type 'exit' to stop)");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop if the user enters "exit"
            }

            try {
                int intValue = Integer.parseInt(input);
                medicationsID.add(intValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        boolean result = controller.setMedicationList(prescriptionID,medicationsID);
        if(result){
            System.out.println("Update completed");
        }
        else{
            System.out.println("Invalid input values");
            setMedicationList();

        }



    }
    public void removeMedication(){
        System.out.println("----------------------- REMOVING MEDICATION FROM PRESCRIPTION -----------------------");
        Scanner scanner = new Scanner(System.in);
        int prescriptionID,medicationID;
        System.out.println("Prescription ID: ");
        prescriptionID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Medication ID: ");
        medicationID = scanner.nextInt();
        boolean result = controller.removeMedication(prescriptionID,medicationID);
        if(result){
            System.out.println("Update completed");
        }
        else {
            System.out.println("Invalid input values");
            removeMedication();
        }

    }
    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING PRESCRIPTION -----------------------");
        int prescriptionID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prescription ID: ");
        prescriptionID = scanner.nextInt();
        boolean result = controller.remove(prescriptionID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        System.out.println("No updates available");
    }

    @Override
    public void viewAll() {
        for (Prescription prescription : controller.getAll()) {
            System.out.println(prescription);
        }

    }
}
