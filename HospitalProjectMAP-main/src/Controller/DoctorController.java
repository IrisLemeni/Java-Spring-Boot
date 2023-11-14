package Controller;

import Domain.HospitalConfiguration.Department;
import Domain.HospitalStaff.Doctor;
import Repository.DepartmentRepository;
import Repository.DoctorRepository;

import java.util.ArrayList;
import java.util.Date;

public class DoctorController extends BaseController<Doctor> {
    private DoctorRepository doctorRepository;
    private DepartmentRepository departmentRepository;

    public DoctorController(DoctorRepository repository, DepartmentRepository departmentRepository) {
        super();
        doctorRepository = repository;
        this.departmentRepository = departmentRepository;
    }

    public void add(String firstName, String lastName, Date birthDate, String contact, String address) {
        Doctor doctor = new Doctor(firstName, lastName, birthDate, contact, address);
        doctorRepository.add(doctor);
    }

    public DepartmentRepository getDepartmentRepository() {
        return departmentRepository;
    }


    public boolean updateFirstName(int ID, String name) {
        return doctorRepository.updateFirstName(ID, name);
    }


    public boolean updateLastName(int ID, String name) {
        return doctorRepository.updateLastName(ID, name);
    }


    public boolean updateContact(int ID, String contact) {
        return doctorRepository.updateContact(ID, contact);
    }


    public boolean updateAddress(int ID, String address) {
        return doctorRepository.updateAddress(ID, address);

    }


    public boolean updateBirthDate(int ID, Date date) {
        return doctorRepository.updateBirthDate(ID, date);
    }

    @Override
    public boolean remove(int doctorID) {
        return doctorRepository.remove(doctorID);
    }

    @Override
    public ArrayList<Doctor> getAll() {
        return doctorRepository.getAll();
    }

    public boolean enrollDoctor(int doctorID, int departmentID) {
        return doctorRepository.enrollDoctor(doctorID, departmentID, departmentRepository);
    }

    public boolean removeFromDepartment(int doctorID, int departmentID) {
        return doctorRepository.removeFromDepartment(doctorID, departmentID, departmentRepository);
    }

    public ArrayList<Department> getDepartments(int doctorID) {
        return doctorRepository.getDepartments(doctorID);
    }

    public boolean setDoctorOnCall(int id){
        return doctorRepository.setDoctorOnCall(id);
    }
    public boolean setDoctorsOnCall(ArrayList<Integer> ids){
        return doctorRepository.setDoctorsOnCall(ids);
    }
    public boolean setDoctorOffCall(int id){
        return doctorRepository.setDoctorOffCall(id);
    }
    public boolean setDoctorsOffCall(ArrayList<Integer> ids){
        return doctorRepository.setDoctorsOffCall(ids);
    }
    public ArrayList<Doctor> getOnCallDoctors(){
        return doctorRepository.getOnCallDoctors();
    }
}
