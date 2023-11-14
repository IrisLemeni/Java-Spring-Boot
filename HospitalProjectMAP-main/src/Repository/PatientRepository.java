package Repository;

import Domain.Beneficiaries.Patient;

import java.util.ArrayList;
import java.util.Date;

public class PatientRepository extends BaseRepository<Patient> {
    private ArrayList<Patient> patientRepository;

    public PatientRepository() {
        super();
        this.patientRepository = new ArrayList<>();
    }

    public PatientRepository(ArrayList<Patient> patients) {
        super();
        patientRepository = patients;
    }
    public Patient findByID(int id){
        Patient patient = null;
        for (Patient patient1 : patientRepository) {
            if (patient1.getPatientID() == id) {
                patient = patient1;
                break;
            }
        }
        return patient;
    }
    @Override
    public void add(Patient patient) {
        patientRepository.add(patient);
    }

    @Override
    public boolean remove(int id) {
        Patient patient = findByID(id);
        if(patient == null)
            return false;
        return patientRepository.remove(patient);
    }

    public boolean updateFirstName(int ID, String name) {
        Patient patient = findByID(ID);
        if(patient == null)
            return false;
        patient.setFirstName(name);
        return true;
    }

    public boolean updateLastName(int ID, String name) {
        Patient patient = findByID(ID);
        if(patient == null)
            return false;
        patient.setLastName(name);
        return true;

    }

    public boolean updateBirthDate(int ID, Date date) {
        Patient patient = findByID(ID);
        if(patient == null)
            return false;
        patient.setBirthDate(date);
        return true;
    }


    public boolean updateContact(int ID, String contact) {
        Patient patient = findByID(ID);
        if(patient == null)
            return false;
        patient.setContact(contact);
        return true;

    }

    public boolean updateAddress(int ID, String address) {
        Patient patient = findByID(ID);
        if(patient == null)
            return false;
        patient.setAddress(address);
        return true;

    }

    @Override
    public ArrayList<Patient> getAll() {
        return patientRepository;
    }
}