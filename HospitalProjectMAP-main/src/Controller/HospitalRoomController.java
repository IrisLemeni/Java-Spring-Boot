package Controller;

import Domain.HospitalConfiguration.HospitalRoom;
import Domain.Factory.HospitalRoomFactory;
import Repository.HospitalRoomRepository;

import java.util.ArrayList;
import java.util.Objects;

public class HospitalRoomController extends BaseController<HospitalRoom> {
    private HospitalRoomRepository hospitalRoomRepository;
    private HospitalRoomFactory hospitalRoomFactory;

    public HospitalRoomController(HospitalRoomRepository hospitalRoomRepository, HospitalRoomFactory hospitalRoomFactory) {
        super();
        this.hospitalRoomRepository = hospitalRoomRepository;
        this.hospitalRoomFactory = hospitalRoomFactory;
    }

    public void add(int number, String roomType) {
        if (Objects.equals(roomType, "ExaminationRoom")) {
            hospitalRoomRepository.add(hospitalRoomFactory.createExaminationRoom(number));
            return;
        }
        if (Objects.equals(roomType, "AdmissionRoom")) {
            hospitalRoomRepository.add(hospitalRoomFactory.createAdmissionRoom(number));
        }
    }

    @Override
    public boolean remove(int id) {
        return hospitalRoomRepository.remove(id);
    }

    public boolean setAdmissionRoomToAvailable(int id) {
        return hospitalRoomRepository.setAdmissionRoomToAvailable(id);
    }

    public boolean setAdmissionRoomToUnavailable(int id) {
        return hospitalRoomRepository.setAdmissionRoomToUnavailable(id);
    }

    @Override
    public ArrayList<HospitalRoom> getAll() {
        return hospitalRoomRepository.getAll();
    }
}
