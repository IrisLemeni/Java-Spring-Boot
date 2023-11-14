package Domain.HospitalServices;

import Domain.HospitalStaff.Doctor;
import Domain.Beneficiaries.Patient;

import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private static int nextID = 1;
    private int prescriptionID;
    private Doctor doctor;
    private Patient patient;
    private Date date;

    private ArrayList<Medication> medications;

    public Prescription(Doctor doctor, Patient patient, Date date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.prescriptionID = nextID++;
        medications = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID=" + prescriptionID +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
    public ArrayList<Medication> getMedications() {
        return medications;
    }
    public void addMedication(Medication medication){
        medications.add(medication);

    }
    public boolean removeMedication(Medication medication){
        return medications.remove(medication);
    }
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
    }
    public int getPrescriptionID() {
        return prescriptionID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
