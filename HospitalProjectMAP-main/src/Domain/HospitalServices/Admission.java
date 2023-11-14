package Domain.HospitalServices;

import Domain.HospitalStaff.Doctor;
import Domain.HospitalConfiguration.AdmissionRoom;
import Domain.Beneficiaries.Patient;

import java.util.Date;

public class Admission {
    private static int nextID = 1;
    private int admissionID;
    private Patient patient;
    private Doctor doctor;
    private Date enrollmentDate;
    private Date dischargingDate;
    private AdmissionRoom admissionRoom;

    public Admission(Patient patient, Doctor doctor, Date date) {
        this.patient = patient;
        this.doctor = doctor;
        this.enrollmentDate = date;
        this.admissionID = nextID++;
        this.admissionRoom = null;
    }
    public int getAdmissionID() {
        return admissionID;
    }
    public Date getDischargingDate() {
        return dischargingDate;
    }

    public void setDischargingDate(Date dischargingDate) {
        this.dischargingDate = dischargingDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public AdmissionRoom getAdmissionRoom() {
        return admissionRoom;
    }

    public void setAdmissionRoom(AdmissionRoom admissionRoom) {
        this.admissionRoom = admissionRoom;
        admissionRoom.setToUnavailable();
    }
    @Override
    public String toString() {
        return "Admission{" +
                "admissionID=" + admissionID +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", enrollmentDate=" + enrollmentDate +
                ", dischargingDate=" + dischargingDate +
                ", admissionRoom=" + admissionRoom +
                '}';
    }

}
