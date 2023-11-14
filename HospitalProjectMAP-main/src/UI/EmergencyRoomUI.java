package UI;

import Controller.EmergencyRoomController;
import Domain.HospitalStaff.Doctor;
import Domain.Singleton.PatientInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmergencyRoomUI {
    private EmergencyRoomController controller;

    public EmergencyRoomUI(EmergencyRoomController controller) {
        this.controller = controller;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- DEPARTMENTS ---------------------------");
            System.out.println("1. Add Patient To Waiting List");
            System.out.println("2. Remove Patient From Waiting List");
            System.out.println("3. View Waiting List");
            System.out.println("4. Handle Next Patient From List");
            System.out.println("5. View On Call Doctors");
            System.out.println("6. Set Doctor On Call");
            System.out.println("7. Set Doctors On Call");
            System.out.println("8. Remove On Call Doctor");
            System.out.println("9. Return To The Main Page");
            System.out.println("10. Log Out");

            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    removePatient();
                    break;
                case 3:
                    viewWaitingList();
                    break;
                case 4:
                    handlePatient();
                    break;
                case 5:
                    viewOnCallDocs();
                    break;
                case 6:
                    setDoctorOnCall();
                    break;
                case 7:
                    setDoctorsOnCall();
                    break;
                case 8:
                    removeOnCallDoctor();
                    break;
                case 9:
                    running = false;
                    break;

                case 10:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public void addPatient() {
        System.out.println("----------------------- ADDING TO DATABASE -----------------------");
        String firstName, lastName, contact, address;
        Date birthDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("First Name: ");
        firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        lastName = scanner.nextLine();
        System.out.println("Contact: ");
        contact = scanner.nextLine();
        System.out.println("Address: ");
        address = scanner.nextLine();
        System.out.println("Condition: ");
        String condition = scanner.nextLine();
        System.out.print("Birth date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = dateFormat.parse(dateInput);
            boolean result = controller.addPatient(firstName, lastName, birthDate, contact, address, condition);
            if (!result) {
                System.out.println("Invalid data! Please try again");
                addPatient();
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            addPatient();
        }
        System.out.println("Patient was added successfully!");
        System.out.print("Do you want to continue adding patients? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        switch (response) {
            case "yes":
                addPatient();
                break;
            case "no":
                break;
            default:
                System.out.println("Invalid response. Assuming 'no'.");
                break;
        }
    }

    public void removePatient() {
        System.out.println("---------------------- REMOVING FROM DATABASE ----------------------");
        int patientID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        boolean result = controller.removePatient(patientID);
        if (result)
            System.out.println("Removal completed");
        else {
            System.out.println("Invalid data! Please try again");
            removePatient();
        }
    }

    public void handlePatient() {
        System.out.println("----------------------- HANDLING NEXT PATIENT -----------------------");
        if(!controller.handleNextPatient()){
            System.out.println("No more patients on the waiting list");
        }
    }

    public void viewWaitingList() {
        System.out.println("----------------------- WAITING LIST -----------------------");
        for(PatientInfo patientInfo:controller.getWaitingList()){
            System.out.println(patientInfo);
        }
    }
    public void removeOnCallDoctor() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int doctorID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        boolean result = controller.removeOnCallDoctor(doctorID);
        if (result)
            System.out.println("Removal completed");
        else{
            System.out.println("Invalid data! Please try again");
            removeOnCallDoctor();
        }
    }

    public void viewOnCallDocs() {
        System.out.println("----------------------- ON CALL DOCTORS -----------------------");
        for (Doctor doctor : controller.getOnCallDoctors()) {
            System.out.println(doctor);
        }
    }

    public void setDoctorOnCall() {
        System.out.println("----------------------- SETTING DOCTOR ON CALL -----------------------");
        int doctorID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        boolean result = controller.setDoctorOnCall(doctorID);
        if (result)
            System.out.println("Removal completed");
        else {
            System.out.println("Invalid data! Please try again");
            setDoctorOnCall();
        }

    }

    public void setDoctorsOnCall() {
        System.out.println("----------------------- SETTING ON CALL DOCTORS -----------------------");
        controller.setDoctorsOnCall();
    }

}
