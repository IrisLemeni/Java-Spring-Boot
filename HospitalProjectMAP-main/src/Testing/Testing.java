package Testing;

import Controller.*;
import Domain.Beneficiaries.Patient;
import Domain.Factory.HospitalRoomFactory;
import Domain.HospitalConfiguration.AdmissionRoom;
import Domain.HospitalConfiguration.Department;
import Domain.HospitalConfiguration.ExaminationRoom;
import Domain.HospitalConfiguration.HospitalRoom;
import Domain.HospitalServices.Medication;
import Domain.HospitalStaff.Doctor;
import Repository.*;
import UI.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Testing {
    public static ArrayList<Patient> PatientRepo(){
        ArrayList<Patient> patients = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.OCTOBER, 28);
        Date date = calendar.getTime();
        Patient patient1 = new Patient("Sarah","Miller",date,"0752134322","Nasaud 16");
        patients.add(patient1);
        calendar.set(2003,Calendar.JUNE,26);
        date = calendar.getTime();
        Patient patient2 = new Patient("Antonia","Kocsis",date,"0752134333","Dorobantilor 23 ");
        patients.add(patient2);
        patients.add(new Patient("Carina","Bojan",date,"0723331003","Marului 4"));
        calendar.set(2002,Calendar.JUNE,12);
        date = calendar.getTime();
        patients.add(new Patient("Miruna","Sandea",date,"0723050208","Eroilor 33"));
        calendar.set(2002,Calendar.OCTOBER,12);
        date = calendar.getTime();
        patients.add(new Patient("Sergiu","Marian",date,"0723331002","Dorobantilor 101"));
        return patients;
    }
    public static ArrayList<Doctor> DoctorRepo(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.OCTOBER, 28);
        Calendar calendar1= Calendar.getInstance();
        calendar.set(2003, Calendar.JUNE, 2);
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(2003, Calendar.JULY, 23);
        Calendar calendar3 = Calendar.getInstance();
        calendar.set(2003, Calendar.DECEMBER, 12);
        Date date = calendar.getTime();
        Date date1 = calendar1.getTime();
        Date date2 = calendar2.getTime();
        Date date3 = calendar3.getTime();
        doctors.add(new Doctor("Maria","Miclea",date,"0723331004","Nasaud 22"));
        doctors.add(new Doctor("","",date1,"0723231004","Dorobantilor 102"));
        doctors.add(new Doctor("","",date2,"0723131004","Nasaud 13"));
        doctors.add(new Doctor("","",date3,"0723431004","Dorobantilor 104"));
        doctors.add(new Doctor("","",date1,"0723531004","Nasaud 12"));
        doctors.add(new Doctor("","",date,"0723361004","Nasaud 23"));
        doctors.add(new Doctor("","",date2,"0723731004","Nasaud 21"));

        return doctors;
    }

    public static ArrayList<Department> DepartmentRepo(){
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department("Cardiology"));
        departments.add(new Department("Neurology"));
        departments.add(new Department("Pediatrics"));
        departments.add(new Department("Orthopedics"));
        departments.add(new Department("ENT"));
        departments.add(new Department("Dermatology"));
        departments.add(new Department("Infectious Disease"));
        departments.add(new Department("Ophthalmology"));
        departments.add(new Department("Neonatology"));
        departments.add(new Department("Obstetrics and Gynecology "));
        departments.add(new Department("Medical-Surgical Unit"));
        return departments;
    }
    public static ArrayList<Medication> MedicationRepo(){
        ArrayList<Medication> medications = new ArrayList<>();
        medications.add(new Medication("Nurofen",400));
        medications.add(new Medication("Nurofen",200));
        medications.add(new Medication("Claritin",100));
        medications.add(new Medication("Siofor",1000));
        medications.add(new Medication("Nebilet",50));
        medications.add(new Medication("Betalok",50));
        medications.add(new Medication("Debridat",100));
        medications.add(new Medication("Ospen",1000));
        medications.add(new Medication("Augmentin",400));
        return medications;
    }
    public static ArrayList<HospitalRoom> HospitalRepo(){
        ArrayList<HospitalRoom> hospitalRooms = new ArrayList<>();
        hospitalRooms.add(new ExaminationRoom(101));
        hospitalRooms.add(new ExaminationRoom(102));
        hospitalRooms.add(new ExaminationRoom(103));
        hospitalRooms.add(new ExaminationRoom(104));
        hospitalRooms.add(new ExaminationRoom(105));
        hospitalRooms.add(new ExaminationRoom(106));
        hospitalRooms.add(new ExaminationRoom(107));
        hospitalRooms.add(new ExaminationRoom(108));
        hospitalRooms.add(new AdmissionRoom(201));
        hospitalRooms.add(new AdmissionRoom(202));
        hospitalRooms.add(new AdmissionRoom(203));
        hospitalRooms.add(new AdmissionRoom(204));
        hospitalRooms.add(new AdmissionRoom(205));
        hospitalRooms.add(new AdmissionRoom(206));
        hospitalRooms.add(new AdmissionRoom(207));
        hospitalRooms.add(new AdmissionRoom(208));
        return hospitalRooms;
    }
    public static void main(String[] args) {


        PatientRepository patientRepository = new PatientRepository(PatientRepo());
        PatientController patientController = new PatientController(patientRepository);
        PatientUI patientUI = new PatientUI(patientController);

        DepartmentRepository departmentRepository = new DepartmentRepository(DepartmentRepo());
        DoctorRepository doctorRepository  = new DoctorRepository(DoctorRepo());
        DoctorController doctorController = new DoctorController(doctorRepository,departmentRepository);
        DoctorUI doctorUI = new DoctorUI(doctorController);

        MedicationRepository medicationRepository = new MedicationRepository(MedicationRepo());
        MedicationController medicationController = new MedicationController(medicationRepository);
        MedicationUI medicationUI = new MedicationUI(medicationController);

        HospitalRoomRepository hospitalRoomRepository = new HospitalRoomRepository(HospitalRepo());
        HospitalRoomFactory hospitalRoomFactory = new HospitalRoomFactory();
        HospitalRoomController hospitalRoomController  = new HospitalRoomController(hospitalRoomRepository,hospitalRoomFactory);
        HospitalRoomUI hospitalRoomUI = new HospitalRoomUI(hospitalRoomController);


        DepartmentController departmentController = new DepartmentController(departmentRepository,doctorRepository);
        DepartmentUI departmentUI = new DepartmentUI(departmentController);

        PrescriptionRepository prescriptionRepository = new PrescriptionRepository();
        PrescriptionController prescriptionController = new PrescriptionController(prescriptionRepository,patientRepository,doctorRepository,medicationRepository);
        PrescriptionUI prescriptionUI = new PrescriptionUI(prescriptionController);


        AppointmentRepository appointmentRepository = new AppointmentRepository();
        AppointmentController appointmentController = new AppointmentController(appointmentRepository,patientRepository,doctorRepository,hospitalRoomRepository,prescriptionRepository);
        AppointmentUI appointmentUI = new AppointmentUI(appointmentController);














    }


}
