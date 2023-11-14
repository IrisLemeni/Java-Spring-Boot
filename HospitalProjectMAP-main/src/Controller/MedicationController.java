package Controller;

import Domain.HospitalServices.Medication;
import Repository.MedicationRepository;

import java.util.ArrayList;

public class MedicationController extends BaseController<Medication> {
    private MedicationRepository medicationRepository;

    public MedicationController(MedicationRepository medicationRepository) {
        super();
        this.medicationRepository = medicationRepository;
    }

    public void add(String name, int concentration) {
        Medication medication = new Medication(name, concentration);
        medicationRepository.add(medication);
    }

    public boolean updateName(int id, String name) {
        return medicationRepository.updateName(id,name);
    }

    public boolean updateConcentration(int id, int concentration) {
        return medicationRepository.updateConcentration(id,concentration);
    }

    @Override
    public boolean remove(int id) {
        return medicationRepository.remove(id);
    }

    @Override
    public ArrayList<Medication> getAll() {
        return medicationRepository.getAll();
    }
}

