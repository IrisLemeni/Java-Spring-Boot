package UI;

import Controller.HospitalRoomController;
import Domain.HospitalConfiguration.HospitalRoom;

import java.util.Scanner;

public class HospitalRoomUI extends BaseUI {
    private HospitalRoomController controller;

    public HospitalRoomUI(HospitalRoomController controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("------------------------- EXAMINATION ROOMS ---------------------------");
            System.out.println("1. Add Hospital Room");
            System.out.println("2. Remove Hospital Room");
            System.out.println("3. View Hospital Rooms");
            System.out.println("4. Return To The Main Page");
            System.out.println("5. Log Out");

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
                    viewAll();
                    break;
                case 4:
                    running = false;
                    break;

                case 5:
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
        System.out.println("----------------------- ADDING TO DATABASE -----------------------");
        Scanner scanner = new Scanner(System.in);
        int roomNumber;
        System.out.println("1. Examination Room");
        System.out.println("2. Admission Room");

        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter Room Number: ");
                roomNumber = scanner.nextInt();
                controller.add(roomNumber,"ExaminationRoom");
                break;
            case 2:
                System.out.println("Enter Room Number: ");
                roomNumber = scanner.nextInt();
                controller.add(roomNumber,"AdmissionRoom");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                add();
        }

        System.out.println("Examination Room was added successfully!");
    }


    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int roomID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        roomID = scanner.nextInt();
        boolean result = controller.remove(roomID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        System.out.println("No updates available");
    }

    @Override
    public void viewAll() {
        for(HospitalRoom hospitalRoom: controller.getAll()){
            System.out.println(hospitalRoom);
        }
    }
}
