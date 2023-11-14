package UI;

import Controller.MedicationController;
import Domain.HospitalServices.Medication;

import java.util.Objects;
import java.util.Scanner;

public class MedicationUI extends BaseUI {
    private MedicationController controller;

    public MedicationUI(MedicationController controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------- SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("----------------------------- MEDICATIONS ---------------------------");
            System.out.println("1. Add Medication");
            System.out.println("2. Remove Medication");
            System.out.println("3. Update Medication's info");
            System.out.println("4. View All Medications");
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

    @Override
    public void add() {
        System.out.println("----------------------- ADDING TO DATABASE -----------------------");
        Scanner scanner = new Scanner(System.in);
        String name;
        int concentration;
        System.out.println("Name: ");
        name = scanner.nextLine();
        System.out.println("Concentration: ");
        concentration = scanner.nextInt();
        controller.add(name,concentration);
        System.out.println("Medication was added successfully!");

    }

    @Override
    public void remove() {
        System.out.println("----------------------- REMOVING FROM DATABASE -----------------------");
        int medicationID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        medicationID = scanner.nextInt();
        boolean result = controller.remove(medicationID);
        if (result)
            System.out.println("Removal completed");
    }

    @Override
    public void updateInfo() {
        System.out.println("----------------------- UPDATING INFORMATION -----------------------");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Update Name");
            System.out.println("2. Update Concentration");
            System.out.println("3. Return to main page");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String option;
            switch (choice) {
                case 1:
                    updateName();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 2:
                    updateConcentration();
                    System.out.println("Would you like to make any more updates? (yes / no)");
                    option = scanner.nextLine();
                    if (Objects.equals(option, "yes")) {
                        option = "";
                    }
                    if (Objects.equals(option, "no"))
                        running = false;
                    break;
                case 3:
                    scanner.close();
                    running = false;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    public void updateName(){
        int medicationID;
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        medicationID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: ");
        name = scanner.nextLine();
        boolean result = controller.updateName(medicationID, name);
        if (result)
            System.out.println("Update completed");

    }
    public void updateConcentration(){
        int medicationID;
        int concentration;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        medicationID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("New name: ");
        concentration = scanner.nextInt();
        boolean result = controller.updateConcentration(medicationID, concentration);
        if (result)
            System.out.println("Update completed");

    }

    @Override
    public void viewAll() {
        for(Medication medication: controller.getAll()){
            System.out.println(medication);
        }

    }
}
