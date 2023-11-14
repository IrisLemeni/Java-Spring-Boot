package Domain.Singleton;

import Domain.Beneficiaries.Patient;

public class HospitalBillingSystem {
    private static HospitalBillingSystem instance;

    private HospitalBillingSystem() {
    }

    public static HospitalBillingSystem getInstance() {
        if (instance == null) {
            synchronized (HospitalBillingSystem.class) {
                if (instance == null) {
                    instance = new HospitalBillingSystem();
                }
            }
        }
        return instance;
    }

    public void generateBill(Patient patient, double amount) {
        System.out.println("Generating bill for " + patient.getFirstName() + " " + patient.getLastName() + " with amount $" + amount);
    }
}
