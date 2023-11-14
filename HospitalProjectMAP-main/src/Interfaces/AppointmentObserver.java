package Interfaces;

import Domain.HospitalServices.Appointment;

public interface AppointmentObserver {
    void update(Appointment appointment);
}
