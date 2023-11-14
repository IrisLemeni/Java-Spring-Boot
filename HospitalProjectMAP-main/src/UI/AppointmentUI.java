package UI;

import Controller.AppointmentController;
import Domain.HospitalServices.Appointment;
import Interfaces.AppointmentObserver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppointmentUI extends BaseUI {
    private AppointmentController controller;

    public AppointmentUI(AppointmentController controller) {
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- APPOINTMENTS ---------------------------");
            System.out.println("1. Add Appointment");
            System.out.println("2. Remove Appointment");
            System.out.println("3. Update Appointment's info");
            System.out.println("4. View All Appointments");
            System.out.println("5. Appointment Observers");
            System.out.println("6. Return To The Main Page");
            System.out.println("7. Log Out");

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
                    observers();
                    break;
                case 6:
                    running = false;
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public void observers() {
        int appointmentID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appointment ID:");
        appointmentID = scanner.nextInt();
        ArrayList<AppointmentObserver> observers = controller.appointmentObservers(appointmentID);
        for (AppointmentObserver observer : observers) {
            System.out.println(observer);
        }

    }

    @Override
    public void add() {
        System.out.println("----------------------- ADDING TO DATABASE -----------------------");
        Scanner scanner = new Scanner(System.in);
        Date date;
        int doctorID;
        int patientID;
        int roomID;
        String condition;
        System.out.println("Patient ID: ");
        patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Doctor ID: ");
        doctorID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Room ID: ");
        roomID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateInput);
            boolean result = controller.add(patientID, doctorID, date, roomID);
            if (!result) {
                System.out.println("Invalid data, please try again!");
                add();
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            add();
        }
        System.out.println("Appointment was added successfully!");
    }

    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int appointmentID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        appointmentID = scanner.nextInt();
        boolean result = controller.remove(appointmentID);
        if (result)
            System.out.println("Removal completed");
        else {
            System.out.println("Invalid data! Please try again!");
            remove();
        }
    }

    @Override
    public void updateInfo() {
        Scanner scanner = new Scanner(System.in);
        int appointmentID;
        System.out.println("Appointment ID: ");
        appointmentID = scanner.nextInt();
        scanner.nextLine();
        Date date;
        System.out.println("Date (format: yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateInput);
            if (!controller.reschedule(appointmentID, date)){
                System.out.println("Invalid data! Please try again!");
                updateInfo();
            }

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
        System.out.println("Appointment was added successfully!");


    }

    @Override
    public void viewAll() {
        for (Appointment appointment : controller.getAll()) {
            System.out.println(appointment);
        }
    }
}
