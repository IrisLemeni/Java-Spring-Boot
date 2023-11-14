package UI;

import Controller.PatientController;
import Domain.Beneficiaries.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class PatientUI extends BaseUI {

    private PatientController controller;

    public PatientUI(PatientController controller) {
        super();
        this.controller = controller;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- PATIENTS ---------------------------");
            System.out.println("1. Add Patient");
            System.out.println("2. Remove Patient");
            System.out.println("3. Update Patient's info");
            System.out.println("4. View All Patients");
            System.out.println("5. Return To The Main Page");
            System.out.println("6. Log Out");

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
                    updateInfo();
                    break;
                case 4:
                    viewAll();
                    break;
                case 5:
                    running = false;
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public void add() {
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
        System.out.print("Birth date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = dateFormat.parse(dateInput);
            controller.add(firstName, lastName, birthDate, contact, address);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        System.out.println("Patient was added successfully!");
    }

    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int patientID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        boolean result = controller.remove(patientID);
        if (result)
            System.out.println("Removal completed");
    }

    public void updateInfo() {
        System.out.println("----------------------- UPDATING INFORMATION -----------------------");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Update First Name");
            System.out.println("2. Update Last Name");
            System.out.println("3. Update Contact");
            System.out.println("4. Update Address");
            System.out.println("5. Update Birth Date");
            System.out.println("6. Return to main page");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String option;
            switch (choice) {
                case 1:
                    updateFirstName();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 2:
                    updateLastName();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 3:
                    updateContact();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 4:
                    updateAddress();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 5:
                    updateDate();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 6:
                    scanner.close();
                    running = false;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public void updateFirstName() {

        String name;
        int patientID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: ");
        name = scanner.nextLine();
        boolean result = controller.updateFirstName(patientID, name);
        if (result)
            System.out.println("Update completed");
        else {
            System.out.println("Patient not in the system,please try again");
            updateFirstName();
        }
    }

    public void updateLastName() {
        int patientID;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: ");
        name = scanner.nextLine();
        boolean result = controller.updateLastName(patientID, name);
        if (result)
            System.out.println("Update completed");
        else {
            System.out.println("Patient not in the system,please try again");
            updateFirstName();
        }


    }

    public void updateContact() {
        Scanner scanner = new Scanner(System.in);
        int patientID;
        String contact;
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New contact number: ");
        contact = scanner.nextLine();
        boolean result = controller.updateContact(patientID, contact);
        if (result)
            System.out.println("Update completed");
        else {
            System.out.println("Patient not in the system,please try again");
            updateFirstName();
        }

    }

    public void updateAddress() {
        int patientID;
        String address;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New address: ");
        address = scanner.nextLine();
        boolean result = controller.updateAddress(patientID, address);
        if (result)
            System.out.println("Update completed");
        else {
            System.out.println("Patient not in the system,please try again");
            updateFirstName();
        }

    }

    public void updateDate() {
        int patientID;
        Date birthDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Birth date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = dateFormat.parse(dateInput);
            boolean result = controller.updateBirthDate(patientID, birthDate);
            if (result) {
                System.out.println("Update completed");
            }
            else {
                System.out.println("Patient not in the system,please try again");
                updateFirstName();
            }

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }


    }

    public void viewAll() {
        System.out.println("----------------------- ALL PATIENTS -----------------------");
        ArrayList<Patient> patients = controller.getAll();
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

}
