package Controller;

import Domain.Beneficiaries.Patient;
import Domain.HospitalConfiguration.ExaminationRoom;
import Domain.HospitalConfiguration.HospitalRoom;
import Domain.HospitalServices.Appointment;
import Domain.HospitalStaff.Doctor;
import Interfaces.AppointmentObserver;
import Repository.*;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentController extends BaseController<Appointment> {
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private HospitalRoomRepository hospitalRoomRepository;
    private PrescriptionRepository prescriptionRepository;

    public AppointmentController(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, HospitalRoomRepository hospitalRoomRepository,PrescriptionRepository prescriptionRepository) {
        super();
        this.prescriptionRepository = prescriptionRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.hospitalRoomRepository = hospitalRoomRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public boolean add(int patientID, int doctorID, Date date, int examinationRoomID) {
        Patient patient = patientRepository.findByID(patientID);
        Doctor doctor = doctorRepository.findByID(doctorID);
        HospitalRoom examinationRoom = hospitalRoomRepository.findByID(examinationRoomID);
        if(!(examinationRoom instanceof ExaminationRoom))
            return false;
        if (patient == null || doctor == null)
            return false;
        Appointment appointment = new Appointment(patient, doctor, date, (ExaminationRoom) examinationRoom);
        appointmentRepository.add(appointment);
        return true;
    }

    public boolean reschedule(int appointmentID, Date date) {
        return appointmentRepository.reschedule(appointmentID, date);
    }

    @Override
    public boolean remove(int appointmentID) {
        return appointmentRepository.remove(appointmentID);
    }

    @Override
    public ArrayList<Appointment> getAll() {
        return appointmentRepository.getAll();
    }

    public ArrayList<AppointmentObserver> appointmentObservers(int appointmentID) {
        return appointmentRepository.appointmentObservers(appointmentID);
    }
}
