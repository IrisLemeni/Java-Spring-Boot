package Domain.HospitalConfiguration;

public class HospitalRoom {
    private int roomID;
    private int roomNumber;
    private static int nextID = 1;

    public HospitalRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        roomID = nextID++;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
