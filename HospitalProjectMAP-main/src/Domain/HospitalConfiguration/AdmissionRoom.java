package Domain.HospitalConfiguration;

public class AdmissionRoom extends HospitalRoom {
    boolean available;
    public AdmissionRoom(int roomNumber) {
        super(roomNumber);
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setToAvailable(){
        available = true;
    }
    public void setToUnavailable(){
        available = false;
    }
    @Override
    public String toString() {
        return "AdmissionRoom{" +
                "roomID=" + this.getRoomID()+
                ", roomNumber=" + this.getRoomNumber() +
                '}';
    }
}
