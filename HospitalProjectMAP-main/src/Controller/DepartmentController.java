package Controller;

import Domain.HospitalConfiguration.Department;
import Domain.HospitalStaff.Doctor;
import Repository.DepartmentRepository;
import Repository.DoctorRepository;

import java.util.ArrayList;

public class DepartmentController extends BaseController<Department> {
    private DepartmentRepository departmentRepository;
    private DoctorRepository doctorRepository;

    public DepartmentController(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        super();
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public void add(String name) {
        Department department = new Department(name);
        departmentRepository.add(department);
    }

    public boolean enrollDoctor(int departmentID, int doctorID) {
            return departmentRepository.enrollDoctor(departmentID,doctorID,doctorRepository);
    }

    public boolean removeDoctor(int departmentID, int doctorID) {
        return departmentRepository.removeDoctor(departmentID,doctorID,doctorRepository);
    }

    public boolean updateName(int id, String name) {
        return departmentRepository.updateName(id,name);
    }

    @Override
    public boolean remove(int id) {
        return departmentRepository.remove(id);
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository.getAll();
    }

    public ArrayList<Doctor> getEnrolledDoctors(int departmentID) {

        return departmentRepository.getEnrolledDoctors(departmentID);

    }
}
