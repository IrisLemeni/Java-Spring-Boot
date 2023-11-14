package UI;

import java.util.Scanner;

public class UI {
    private PatientUI patientUI;
    private MedicationUI medicationUI;
    private DoctorUI doctorUI;
    private DepartmentUI departmentUI;
    private HospitalRoomUI hospitalRoomUI;
    private AppointmentUI appointmentUI;
    private PrescriptionUI prescriptionUI;
    private EmergencyRoomUI emergencyRoomUI;

    public UI(PatientUI patientUI, MedicationUI medicationUI, DoctorUI doctorUI,DepartmentUI departmentUI,HospitalRoomUI hospitalRoomUI,AppointmentUI appointmentUI,PrescriptionUI prescriptionUI,EmergencyRoomUI emergencyRoomUI) {
        this.patientUI = patientUI;
        this.medicationUI = medicationUI;
        this.doctorUI = doctorUI;
        this.departmentUI = departmentUI;
        this.hospitalRoomUI = hospitalRoomUI;
        this.appointmentUI = appointmentUI;
        this.prescriptionUI = prescriptionUI;
        this.emergencyRoomUI = emergencyRoomUI;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------- WELCOME TO SEATTLE GRACE HOSPITAL -----------------------");
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Medications");
            System.out.println("4. Appointments");
            System.out.println("5. Prescriptions");
            System.out.println("6. Departments");
            System.out.println("7. Hospital Rooms");
            System.out.println("8. Emergency Room");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String option;
            switch (choice) {
                case 1:
                    patientUI.menu();
                    break;
                case 2:
                    doctorUI.menu();
                    break;
                case 3:
                    medicationUI.menu();
                    break;
                case 4:
                    appointmentUI.menu();
                    break;
                case 5:
                    prescriptionUI.menu();
                    break;
                case 6:
                    departmentUI.menu();
                    break;
                case 7:
                    hospitalRoomUI.menu();
                    break;
                case 8:
                    emergencyRoomUI.menu();
                    break;
                case 9:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
