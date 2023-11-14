package Controller;

import Domain.HospitalStaff.Doctor;
import Domain.Beneficiaries.Patient;
import Domain.HospitalServices.Prescription;
import Repository.DoctorRepository;
import Repository.MedicationRepository;
import Repository.PatientRepository;
import Repository.PrescriptionRepository;

import java.util.ArrayList;
import java.util.Date;

public class PrescriptionController extends BaseController<Prescription>{
    private PrescriptionRepository prescriptionRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private MedicationRepository medicationRepository;

    public PrescriptionController(PrescriptionRepository prescriptionRepository,PatientRepository patientRepository,DoctorRepository doctorRepository,MedicationRepository medicationRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.medicationRepository = medicationRepository;
    }
    public boolean addMedication(int prescriptionID,int medicationID){
        return prescriptionRepository.addMedication(prescriptionID,medicationID,medicationRepository);
    }
    public boolean removeMedication(int prescriptionID,int medicationID){
        return prescriptionRepository.removeMedication(prescriptionID,medicationID,medicationRepository);
    }
    public boolean setMedicationList(int prescriptionID,ArrayList<Integer> medicationIDList ){
        return prescriptionRepository.setMedicationList(prescriptionID,medicationIDList,medicationRepository);
    }


    public boolean add(int doctorID, int patientID, Date date){
        Patient patient = patientRepository.findByID(patientID);
        Doctor doctor = doctorRepository.findByID(doctorID);
        if(patient == null || doctor == null)
            return false;
        Prescription prescription = new Prescription(doctor,patient,date);
        prescriptionRepository.add(prescription);
        return true;
    }


    @Override
    public boolean remove(int id) {
        return prescriptionRepository.remove(id);
    }

    @Override
    public ArrayList<Prescription> getAll() {
        return prescriptionRepository.getAll();
    }
}
