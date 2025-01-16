package parkinglot.models;

public class Vehicle {
    private String registrationNo;
    private VehicleType vehicleType;
    private String color;

    public Vehicle() {
    }

    public Vehicle(String registrationNo, VehicleType vehicleType, String color) {
        this.registrationNo = registrationNo;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
