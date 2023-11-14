package Domain.Factory;

import Domain.HospitalConfiguration.AdmissionRoom;
import Domain.HospitalConfiguration.ExaminationRoom;
import Domain.HospitalConfiguration.HospitalRoom;

public class HospitalRoomFactory {
    public HospitalRoom createExaminationRoom(int roomNumber) {
        return new ExaminationRoom(roomNumber);
    }

    public HospitalRoom createAdmissionRoom(int roomNumber) {
        return  new AdmissionRoom(roomNumber);
    }
}
