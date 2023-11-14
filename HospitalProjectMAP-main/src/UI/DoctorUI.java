package UI;

import Controller.DoctorController;
import Domain.HospitalConfiguration.Department;
import Domain.HospitalStaff.Doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class DoctorUI extends BaseUI {
    private DoctorController controller;

    public DoctorUI(DoctorController controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- DOCTORS ---------------------------");
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. Update Doctor's info");
            System.out.println("4. Enroll Doctor In Department");
            System.out.println("5. Remove Department");
            System.out.println("6. View Departments");
            System.out.println("7. View All Doctors");
            System.out.println("8. Return To The Main Page");
            System.out.println("9. Log Out");

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
                    enrollDoctor();
                    break;
                case 5:
                    removeDepartment();
                    break;
                case 6:
                    viewDepartments();
                    break;
                case 7:
                    viewAll();
                    break;
                case 8:
                    running = false;
                    break;

                case 9:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    public void enrollDoctor(){
        Scanner scanner = new Scanner(System.in);
        int departmentID,doctorID;
        System.out.println("Doctor ID");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Department ID");
        departmentID = scanner.nextInt();
        controller.enrollDoctor(doctorID,departmentID);


    }
    public void removeDepartment(){
        Scanner scanner = new Scanner(System.in);
        int departmentID,doctorID;
        System.out.println("Doctor ID");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Department ID");
        departmentID = scanner.nextInt();
        controller.removeFromDepartment(doctorID,departmentID);
    }
    @Override
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
        System.out.println("Doctor was added successfully!");
    }

    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int doctorID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        doctorID = scanner.nextInt();
        boolean result = controller.remove(doctorID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
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
        int doctorID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: ");
        name = scanner.nextLine();
        boolean result = controller.updateFirstName(doctorID, name);
        if (result)
            System.out.println("Update completed");
    }

    public void updateLastName() {

        String name;
        int doctorID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: ");
        name = scanner.nextLine();
        boolean result = controller.updateLastName(doctorID, name);
        if (result)
            System.out.println("Update completed");


    }

    public void updateContact() {
        Scanner scanner = new Scanner(System.in);
        int doctorID;
        String contact;
        System.out.println("Enter ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New contact number: ");
        contact = scanner.nextLine();
        boolean result = controller.updateContact(doctorID, contact);
        if (result)
            System.out.println("Update completed");

    }

    public void updateAddress() {
        int doctorID;
        String address;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New address: ");
        address = scanner.nextLine();
        boolean result = controller.updateAddress(doctorID, address);
        if (result)
            System.out.println("Update completed");

    }

    public void updateDate() {
        int doctorID;
        Date birthDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Birth date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthDate = dateFormat.parse(dateInput);
            boolean result = controller.updateBirthDate(doctorID, birthDate);
            if (result) {
                System.out.println("Update completed");
            }

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }


    }

    @Override
    public void viewAll() {
        System.out.println("----------------------- ALL DOCTORS -----------------------");
        for (Doctor doctor : controller.getAll()) {
            System.out.println(doctor);
        }
    }
    public void viewDepartments(){
        System.out.println("----------------------- DEPARTMENTS -----------------------");
        Scanner scanner = new Scanner(System.in);
        int doctorID;
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        for(Department department: controller.getDepartments(doctorID)){
            System.out.println(department);
        }
    }
}
