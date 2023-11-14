package Domain.HospitalConfiguration;

public class ExaminationRoom extends HospitalRoom {
    public ExaminationRoom(int number) {
        super(number);
    }

    @Override
    public String toString() {
        return "ExaminationRoom{" +
                "roomID=" + this.getRoomID()+
                ", roomNumber=" + this.getRoomNumber() +
                '}';
    }
}
