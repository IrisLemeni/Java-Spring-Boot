package UI;

import Controller.DepartmentController;
import Domain.HospitalConfiguration.Department;
import Domain.HospitalStaff.Doctor;

import java.util.Scanner;

public class DepartmentUI extends BaseUI{
    private DepartmentController controller;

    public DepartmentUI(DepartmentController controller) {
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- DEPARTMENTS ---------------------------");
            System.out.println("1. Add Department");
            System.out.println("2. Remove Department");
            System.out.println("3. Enroll Doctor In Department");
            System.out.println("4. Remove Doctor From Department");
            System.out.println("5. Update Department's name");
            System.out.println("6. View All Departments");
            System.out.println("7. View Enrolled Doctors");
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
                case 4:enrollDoctor();
                    break;
                case 5:removeDoctor();
                    break;
                case 6:
                    viewAll();
                    break;
                case 7:
                    viewEnrolledDoctors();
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

    @Override
    public void add() {
        System.out.println("----------------------- ADDING DEPARTMENT -----------------------");
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Name: ");
        name = scanner.nextLine();
        controller.add(name);
        System.out.println("Department was added successfully!");
    }
    public void enrollDoctor(){
        System.out.println("----------------------- ENROLL DOCTOR -----------------------");
        Scanner scanner = new Scanner(System.in);
        int departmentID,doctorID;
        System.out.println("Department ID");
        departmentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Doctor ID");
        doctorID = scanner.nextInt();
        controller.enrollDoctor(departmentID,doctorID);

    }
    public void removeDoctor(){
        System.out.println("----------------------- REMOVE DOCTOR -----------------------");
        Scanner scanner = new Scanner(System.in);
        int departmentID,doctorID;
        System.out.println("Department ID");
        departmentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Doctor ID");
        doctorID = scanner.nextInt();
        controller.removeDoctor(departmentID,doctorID);
    }
    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING DEPARTMENT -----------------------");
        int patientID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        patientID = scanner.nextInt();
        boolean result = controller.remove(patientID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        System.out.println("----------------------- UPDATING INFORMATION -----------------------");
        Scanner scanner  = new Scanner(System.in);
        int id;
        String name;
        System.out.println("Department ID: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New Name: ");
        name = scanner.nextLine();
        controller.updateName(id,name);
    }

    @Override
    public void viewAll() {
        for(Department department: controller.getAll()){
            System.out.println(department);
        }

    }
    public void viewEnrolledDoctors(){
        System.out.println("----------------------- ENROLLED DOCTORS -----------------------");
        Scanner scanner = new Scanner(System.in);
        int departmentID;
        System.out.println("Department ID: ");
        departmentID = scanner.nextInt();
        for(Doctor doctor: controller.getEnrolledDoctors(departmentID)){
            System.out.println(doctor);
        }
    }
}
