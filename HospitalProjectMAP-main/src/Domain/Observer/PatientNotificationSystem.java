package Domain.Observer;

import Domain.HospitalServices.Appointment;
import Domain.Beneficiaries.Patient;
import Interfaces.AppointmentObserver;

public class PatientNotificationSystem implements AppointmentObserver {
    private Patient patient;
    private static int numberOfUpdates = 0;

    public PatientNotificationSystem(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "PatientNotificationSystem{" +
                "patient=" + patient +
                "numberOfUpdates=" + numberOfUpdates +
                '}';
    }

    @Override
    public void update(Appointment appointment) {
        numberOfUpdates++;
        System.out.println(patient.getFirstName() + patient.getLastName() + " - Latest appointment update: " + appointment);
    }
}
