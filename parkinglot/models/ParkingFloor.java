package parkinglot.models;

import java.util.ArrayList;

public class ParkingFloor {
    private int floorNumber;
    private ArrayList<ParkingSlot> parkingSlots;

    public ParkingFloor() {
    }

    public ParkingFloor(int floorNumber, ArrayList<ParkingSlot> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ArrayList<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(ArrayList<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
