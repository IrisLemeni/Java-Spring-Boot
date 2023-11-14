package Domain.Strategy;

import Domain.HospitalStaff.Doctor;
import Domain.Beneficiaries.Patient;
import Interfaces.PatientHandlingStrategy;

public class CriticalConditionStrategy implements PatientHandlingStrategy {
    @Override
    public void handlePatient(Patient patient, Doctor doctor) {
        System.out.println("Doctor" +  doctor + " Admitting patient " + patient + " with CRITICAL/SERIOUS condition.");
    }
}
