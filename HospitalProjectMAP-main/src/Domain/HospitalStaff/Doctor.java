package Domain.HospitalStaff;

import Domain.HospitalConfiguration.Department;

import java.util.ArrayList;
import java.util.Date;
public class Doctor {
    private static int nextID = 1;
    private int doctorID;
    private String firstName;
    private String lastName;
    private String contact;
    private String address;
    private Date birthDate;
    private boolean onCall;
    private ArrayList<Department> departments;

    public Doctor(String firstName, String lastName, Date birthDate ,String contact,String address) {
        this.firstName = firstName;
        doctorID = nextID++;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.contact = contact;
        departments = new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void enrollInDepartment(Department department){
        departments.add(department);
    }
    public boolean removeDepartment(Department department){
       return departments.remove(department);
    }
    public boolean isOnCall() {
        return onCall;
    }

    public void setOnCall(boolean onCall) {
        this.onCall = onCall;
    }

}
