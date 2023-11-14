package Domain.HospitalConfiguration;

import Domain.HospitalStaff.Doctor;

import java.util.ArrayList;

public class Department {
    private int departmentID;
    private static int nextID = 1;
    private String name;

    private ArrayList<Doctor> doctors;

    public Department(String name) {
        this.name = name;
        this.departmentID = nextID++;
        doctors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                '}';
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrollDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public boolean removeDoctor(Doctor doctor) {
        return doctors.remove(doctor);
    }
}
