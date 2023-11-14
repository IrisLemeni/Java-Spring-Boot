package Domain.HospitalServices;

public class Medication {
    private int medicationID;
    private int concentration;
    private String name;
    private static int nextID = 1;

    public Medication(String name, int concentration) {
        this.medicationID = nextID++;
        this.name = name;
        this.concentration = concentration;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getMedicationID() {
        return medicationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationID=" + medicationID +
                ", concentration=" + concentration +
                ", name='" + name + '\'' +
                '}';
    }
}
