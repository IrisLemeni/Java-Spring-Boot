package Controller;

import Domain.HospitalStaff.Doctor;
import Domain.Singleton.EmergencyRoom;
import Domain.Beneficiaries.Patient;
import Domain.Singleton.PatientInfo;
import PatientState.PatientCondition;
import Repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class EmergencyRoomController {
    private EmergencyRoom emergencyRoom;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private AdmissionRepository admissionRepository;
    private PrescriptionRepository prescriptionRepository;
    private HospitalRoomRepository hospitalRoomRepository;

    public EmergencyRoomController(EmergencyRoom room, DoctorRepository doctorRepository, PatientRepository patientRepository, AdmissionRepository admissionRepository, PrescriptionRepository prescriptionRepository,HospitalRoomRepository hospitalRoomRepository) {
        emergencyRoom = room;
        emergencyRoom.resetWaitingList();
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.admissionRepository = admissionRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.hospitalRoomRepository = hospitalRoomRepository;
    }

    public boolean addPatient(String firstName, String lastName, Date birthDate, String contact, String address, String condition) {
        if (!Objects.equals(condition, "CRITICAL") && !Objects.equals(condition, "SERIOUS") && !Objects.equals(condition, "STABLE"))
            return false;
        Patient patient = new Patient(firstName, lastName, birthDate, contact, address);
        Date date = new Date();
        patientRepository.add(patient);
        if (Objects.equals(condition, "CRITICAL"))
            emergencyRoom.addToWaitingList(patient, PatientCondition.CRITICAL, date);
        else if (Objects.equals(condition, "STABLE"))
            emergencyRoom.addToWaitingList(patient, PatientCondition.STABLE, date);
        else
            emergencyRoom.addToWaitingList(patient, PatientCondition.SERIOUS, date);
        return true;
    }

    public boolean removePatient(int id) {
        return emergencyRoom.removeFromWaitingList(id);
    }

    public ArrayList<PatientInfo> getWaitingList() {
        return emergencyRoom.getWaitingList();
    }

    public boolean setDoctorOnCall(int id) {
        return emergencyRoom.addOnCallDoctor(id, doctorRepository);
    }

    public void setDoctorsOnCall() {
        emergencyRoom.setDoctorsOnCall(doctorRepository.getOnCallDoctors());
    }

    public boolean removeOnCallDoctor(int id) {
        return emergencyRoom.removeOnCallDoctor(id, doctorRepository);
    }

    public ArrayList<Doctor> getOnCallDoctors() {
        return emergencyRoom.getDoctorsOnCall();
    }

    public boolean handleNextPatient() {
        return emergencyRoom.handleNextPatient(admissionRepository, prescriptionRepository,hospitalRoomRepository);
    }

}
