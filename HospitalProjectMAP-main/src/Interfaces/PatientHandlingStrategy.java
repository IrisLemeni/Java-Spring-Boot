package Interfaces;

import Domain.HospitalStaff.Doctor;
import Domain.Beneficiaries.Patient;

public interface PatientHandlingStrategy {
    void handlePatient(Patient patient, Doctor doctor);
}
