package Domain.Strategy;

import Domain.HospitalStaff.Doctor;
import Domain.Beneficiaries.Patient;
import Interfaces.PatientHandlingStrategy;

public class NonCriticalConditionStrategy implements PatientHandlingStrategy {
    @Override
    public void handlePatient(Patient patient, Doctor doctor) {
        System.out.println("Doctor: "+doctor+" Writing prescription for patient: " + patient+ " with NON-CRITICAL condition.");
    }
}
