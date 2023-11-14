package Controller;

import Domain.Beneficiaries.Patient;
import Repository.PatientRepository;

import java.util.ArrayList;
import java.util.Date;

public class PatientController extends BaseController<Patient> {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    public void add(String firstName, String lastName, Date birthDate, String contact, String address) {
        Patient patient = new Patient(firstName, lastName, birthDate, contact, address);
        patientRepository.add(patient);
    }

    public boolean remove(int patientID) {
        return patientRepository.remove(patientID);
    }


    public boolean updateFirstName(int ID, String name) {
        return patientRepository.updateFirstName(ID,name);

    }

    public boolean updateLastName(int ID, String name) {
        return patientRepository.updateLastName(ID,name);
    }

    public boolean updateBirthDate(int ID, Date date) {
        return patientRepository.updateBirthDate(ID,date);
    }


    public boolean updateContact(int ID, String contact) {
        return patientRepository.updateContact(ID,contact);
    }

    public boolean updateAddress(int ID, String address) {
        return patientRepository.updateAddress(ID,address);

    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository.getAll();
    }


}
