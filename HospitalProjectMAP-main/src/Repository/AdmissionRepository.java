package Repository;

import Domain.HospitalServices.Admission;
import Domain.HospitalConfiguration.AdmissionRoom;

import java.util.ArrayList;
import java.util.Date;

public class AdmissionRepository extends BaseRepository<Admission> {
    private ArrayList<Admission> admissionRepository;

    public AdmissionRepository() {
        super();
        this.admissionRepository = new ArrayList<>();
    }

    @Override
    public void add(Admission item) {
        admissionRepository.add(item);
    }

    public Admission findByID(int id) {
        Admission admission = null;
        for (Admission admission1 : admissionRepository) {
            if (admission1.getAdmissionID() == id) {
                admission = admission1;
                break;
            }
        }
        return admission;
    }

    @Override
    public boolean remove(int id) {
        Admission admission = findByID(id);
        if (admission == null)
            return false;
        return admissionRepository.remove(admission);
    }

    @Override
    public ArrayList<Admission> getAll() {
        return admissionRepository;
    }

    public boolean setDischargingDate(int id, Date date) {
        Admission admission = findByID(id);
        if (admission == null)
            return false;
        admission.setDischargingDate(date);
        return true;
    }

    public boolean setAdmissionRoom(int id, HospitalRoomRepository hospitalRoomRepository) {
        Admission admission = findByID(id);
        if (admission == null)
            return false;
        AdmissionRoom admissionRoom = hospitalRoomRepository.firstFree();
        if (admission.getAdmissionRoom() != null)
            hospitalRoomRepository.setAdmissionRoomToAvailable(admission.getAdmissionRoom().getRoomID());
        admission.setAdmissionRoom(admissionRoom);
        hospitalRoomRepository.setAdmissionRoomToUnavailable(admissionRoom.getRoomID());
        return true;
    }
}
