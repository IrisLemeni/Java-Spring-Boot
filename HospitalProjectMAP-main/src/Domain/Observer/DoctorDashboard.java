package Domain.Observer;

import Domain.HospitalServices.Appointment;
import Domain.HospitalStaff.Doctor;
import Interfaces.AppointmentObserver;

public class DoctorDashboard implements AppointmentObserver {
    private Doctor doctor;

    public static int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    private static int numberOfUpdates = 0;

    public DoctorDashboard(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorDashboard{" +
                "doctor=" + doctor +
                "numberOfUpdates=" + numberOfUpdates +
                '}';
    }

    @Override
    public void update(Appointment appointment) {
        numberOfUpdates++;
        System.out.println(doctor.getFirstName() + " " + doctor.getLastName() + " - Latest update: " + appointment);
    }
}
