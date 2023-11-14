package Repository;

import Domain.HospitalConfiguration.Department;
import Domain.HospitalStaff.Doctor;

import java.util.ArrayList;

public class DepartmentRepository extends BaseRepository<Department> {
    private ArrayList<Department> departmentRepository;

    public DepartmentRepository() {
        super();
        this.departmentRepository = new ArrayList<>();
    }

    public DepartmentRepository(ArrayList<Department> departments) {
        super();
        departmentRepository = departments;

    }
    public Department findByID(int departmentID){
        Department department = null;
        for(Department department1: departmentRepository){
            if(department1.getDepartmentID() == departmentID){
                department = department1;
                break;
            }
        }
        return department;
    }

    @Override
    public void add(Department item) {
        departmentRepository.add(item);
    }

    public boolean enrollDoctor(int departmentID,int doctorID,DoctorRepository doctorRepository) {
        Department department = findByID(departmentID);
        Doctor doctor = doctorRepository.findByID(doctorID);
        if(department == null || doctor == null)
            return false;
        if (!department.getDoctors().contains(doctor))
            department.enrollDoctor(doctor);
        if (!doctor.getDepartments().contains(department))
            doctor.enrollInDepartment(department);
        return true;
    }

    public boolean removeDoctor(int departmentID,int doctorID,DoctorRepository doctorRepository) {
        Department department = findByID(departmentID);
        Doctor doctor = doctorRepository.findByID(doctorID);
        if(department == null || doctor == null)
            return false;
        department.removeDoctor(doctor);
        doctor.removeDepartment(department);
        return true;
    }

    @Override
    public boolean remove(int id) {
        Department department = findByID(id);
        return departmentRepository.remove(department);
    }

    @Override
    public ArrayList<Department> getAll() {
        return departmentRepository;
    }

    public boolean updateName(int departmentID, String name) {
        Department department = findByID(departmentID);
        if(department == null)
            return false;
        department.setName(name);
        return true;
    }

    public ArrayList<Doctor> getEnrolledDoctors(int departmentID) {
        Department department = findByID(departmentID);
        if (department == null)
            return new ArrayList<>();
        return department.getDoctors();
    }
}
