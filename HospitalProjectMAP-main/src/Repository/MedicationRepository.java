package Repository;

import Domain.HospitalServices.Medication;

import java.util.ArrayList;

public class MedicationRepository extends BaseRepository<Medication> {
    private ArrayList<Medication> medicationRepository;

    public MedicationRepository() {
        super();
        this.medicationRepository = new ArrayList<>();
    }
    public MedicationRepository(ArrayList<Medication> medications){
        super();
        medicationRepository = medications;
    }
    public Medication findByID(int id){
        Medication medication = null;
        for(Medication medication1:medicationRepository){
            if(medication1.getMedicationID() == id){
                medication = medication1;
                break;
            }
        }
        return medication;
    }
    @Override
    public void add(Medication item) {
        medicationRepository.add(item);
    }

    @Override
    public boolean remove(int medicationID) {
        Medication medication = findByID(medicationID);
        if(medication == null)
            return false;
        return medicationRepository.remove(medication);
    }

    public boolean updateName(int medicationID, String name) {
        Medication medication = findByID(medicationID);
        if(medication == null)
            return false;
        medication.setName(name);
        return true;
    }

    public boolean updateConcentration(int medicationID, int concentration) {
        Medication medication = findByID(medicationID);
        if(medication == null)
            return false;
        medication.setConcentration(concentration);
        return true;
    }

    @Override
    public ArrayList<Medication> getAll() {
        return medicationRepository;
    }
}
