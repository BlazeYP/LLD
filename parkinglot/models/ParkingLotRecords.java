package parkinglot.models;

import java.util.ArrayList;

public class ParkingLotRecords {
    private ArrayList<ParkingLot> parkingLots;

    public ParkingLotRecords() {
    }

    public ParkingLotRecords(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
