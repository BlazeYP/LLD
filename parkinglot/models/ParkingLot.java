package parkinglot.models;

import java.util.ArrayList;

public class ParkingLot {
    private String parkingLotId;
    private String parkingLotName;
    private int floorCount;
    private String parkingLotAddress;
    private ArrayList<ParkingFloor> parkingFloors;

    public ParkingLot() {
    }

    public ParkingLot(String parkingLotId, String parkingLotName, int floorCount, String parkingLotAddress, ArrayList<ParkingFloor> parkingFloors) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
        this.floorCount = floorCount;
        this.parkingLotAddress = parkingLotAddress;
        this.parkingFloors = parkingFloors;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public String getParkingLotAddress() {
        return parkingLotAddress;
    }

    public void setParkingLotAddress(String parkingLotAddress) {
        this.parkingLotAddress = parkingLotAddress;
    }

    public ArrayList<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(ArrayList<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
