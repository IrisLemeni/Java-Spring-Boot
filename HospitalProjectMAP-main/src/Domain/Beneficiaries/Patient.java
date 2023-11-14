package Domain.Beneficiaries;

import java.util.Date;

public class Patient {
    private static int nextID = 1;
    private int patientID;
    private String contact;
    private String address;

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    private String firstName;
    private String lastName;
    private Date birthDate;

    public int getPatientID() {
        return patientID;
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

    public Patient(String firstName, String lastName, Date birthDate, String contact, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.patientID = nextID++;
        this.contact = contact;
        this.address = address;

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
}
