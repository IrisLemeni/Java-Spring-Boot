package Domain.HospitalServices;

import Domain.HospitalStaff.Doctor;
import Domain.HospitalConfiguration.ExaminationRoom;
import Domain.Beneficiaries.Patient;
import Interfaces.AppointmentObserver;

import java.util.ArrayList;
import java.util.Date;

public class Appointment {
    private int appointmentID;
    private static int nextID = 1;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private ExaminationRoom room;

    private ArrayList<AppointmentObserver> observers = new ArrayList<>();

    public Appointment(Patient patient, Doctor doctor, Date date, ExaminationRoom room) {
            this.patient = patient;
            this.doctor = doctor;
            this.date = date;
            this.room = room;
            this.appointmentID = nextID++;
    }

    public int getAppointmentID() {
        return appointmentID;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
            this.date = date;

    }
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", date=" + date +
                ", room=" + room +
                '}';
    }
    public void registerObserver(AppointmentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AppointmentObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (AppointmentObserver observer : observers) {
            observer.update(this);
        }
    }

    public ArrayList<AppointmentObserver> getObservers() {
        return observers;
    }
}
