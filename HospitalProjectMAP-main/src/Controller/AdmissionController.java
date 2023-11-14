package Controller;

import Domain.Beneficiaries.Patient;
import Domain.HospitalServices.Admission;
import Domain.HospitalStaff.Doctor;
import Repository.AdmissionRepository;
import Repository.DoctorRepository;
import Repository.HospitalRoomRepository;
import Repository.PatientRepository;

import java.util.ArrayList;
import java.util.Date;

public class AdmissionController extends  BaseController<Admission>{
    private AdmissionRepository admissionRepository;
    private HospitalRoomRepository hospitalRoomRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    public AdmissionController(AdmissionRepository admissionRepository, HospitalRoomRepository hospitalRoomRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.admissionRepository = admissionRepository;
        this.hospitalRoomRepository = hospitalRoomRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public boolean add(int patientID, int doctorID,Date date) {
        Patient patient = patientRepository.findByID(patientID);
        Doctor doctor = doctorRepository.findByID(doctorID);
        if(patient == null || doctor== null )
            return false;
        Admission admission = new Admission(patient,doctor,date);
        admissionRepository.add(admission);
        return true;

    }
    @Override
    public boolean remove(int id) {
        return admissionRepository.remove(id);
    }
    @Override
    public ArrayList<Admission> getAll() {
        return admissionRepository.getAll();
    }

    public boolean setDischargingDate(int id, Date date){
        return admissionRepository.setDischargingDate(id,date);
    }
    public boolean setAdmissionRoom(int id){
        return admissionRepository.setAdmissionRoom(id,hospitalRoomRepository);
    }
}
