package Repository;

import Domain.HospitalServices.Medication;
import Domain.HospitalServices.Prescription;

import java.util.ArrayList;

public class PrescriptionRepository extends BaseRepository<Prescription> {
    private ArrayList<Prescription> prescriptionsRepository;

    public PrescriptionRepository() {
        super();
        this.prescriptionsRepository = new ArrayList<>();
    }

    @Override
    public void add(Prescription item) {
        prescriptionsRepository.add(item);
    }
    public Prescription findByID(int ID){
        Prescription prescription = null;
        for(Prescription prescription1:prescriptionsRepository){
            if(prescription1.getPrescriptionID() == ID){
                prescription = prescription1;
                break;
            }
        }
        return prescription;
    }
    @Override
    public boolean remove(int prescriptionID) {
        Prescription prescription = findByID(prescriptionID);
        if(prescription == null)
            return false;
        return prescriptionsRepository.remove(prescription);
    }

    @Override
    public ArrayList<Prescription> getAll() {
        return prescriptionsRepository;
    }
    public boolean addMedication(int prescriptionID, int medicationID,MedicationRepository medicationRepository){
        Prescription prescription = findByID(prescriptionID);
        Medication medication = medicationRepository.findByID(medicationID);
        if(prescription == null || medication == null)
            return false;
        prescription.addMedication(medication);
        return true;

    }
    public boolean removeMedication(int prescriptionID, int medicationID,MedicationRepository medicationRepository){
        Prescription prescription = findByID(prescriptionID);
        Medication medication = medicationRepository.findByID(medicationID);
        if(prescription == null || medication == null)
            return false;
        prescription.addMedication(medication);
        return prescription.removeMedication(medication);
    }
    public boolean setMedicationList(int prescriptionID,ArrayList<Integer> medicationIDList,MedicationRepository medicationRepository ){
        Prescription prescription = findByID(prescriptionID);
        ArrayList<Medication> medications = new ArrayList<>();
        if(prescription == null)
            return false;
        ArrayList<Integer> ids = new ArrayList<>();
        for(Medication medication:medicationRepository.getAll()){
            if(medicationIDList.contains(medication.getMedicationID())){
                medications.add(medication);
            }
            ids.add(medication.getMedicationID());
        }
        for(Integer id: medicationIDList){
            if(!ids.contains(id)){
                return false;
            }
        }
        prescription.setMedications(medications);
        return true;
    }
}
