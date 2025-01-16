package parkinglot.models;

import java.util.ArrayList;

public class VehicleRecords {
    private ArrayList<Vehicle> vehicleList;

    public VehicleRecords() {
    }

    public VehicleRecords(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
