package Repository;

import Domain.HospitalServices.Appointment;
import Domain.Observer.DoctorDashboard;
import Domain.Observer.PatientNotificationSystem;
import Interfaces.AppointmentObserver;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentRepository extends BaseRepository<Appointment> {
    private ArrayList<Appointment> appointmentRepository;

    public AppointmentRepository() {
        super();
        this.appointmentRepository = new ArrayList<>();
    }

    @Override
    public ArrayList<Appointment> getAll() {
        return appointmentRepository;
    }

    @Override
    public void add(Appointment appointment) {
        // Observer registration
        DoctorDashboard doctorDashboard = new DoctorDashboard(appointment.getDoctor());
        PatientNotificationSystem patientNotificationSystem = new PatientNotificationSystem(appointment.getPatient());
        appointment.registerObserver(doctorDashboard);
        appointment.registerObserver(patientNotificationSystem);

        // Adding to repository
        appointmentRepository.add(appointment);

        // Notify all observers
        appointment.notifyObservers();
    }

    public Appointment findByID(int ID) {
        Appointment appointment = null;
        for (Appointment appointment1 : appointmentRepository) {
            if (appointment1.getAppointmentID() == ID) {
                appointment = appointment1;
                break;
            }
        }
        return appointment;
    }

    public boolean remove(int appointmentID) {

        Appointment appointment = findByID(appointmentID);
        if (appointment == null)
            return false;
        return appointmentRepository.remove(appointment);
    }

    public boolean reschedule(int appointmentID, Date date) {
        Appointment appointment = findByID(appointmentID);
        if (appointment == null)
            return false;
        appointment.setDate(date);
        appointment.notifyObservers();
        return true;
    }

    public ArrayList<AppointmentObserver> appointmentObservers(int appointmentID) {
        Appointment appointment = findByID(appointmentID);
        if (appointment == null)
            return new ArrayList<>();
        return appointment.getObservers();
    }
}
