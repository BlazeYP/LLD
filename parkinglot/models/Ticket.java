package parkinglot.models;

public class Ticket {
    private String ticketId;
    private String registrationNo;
    private VehicleType vehicleType;
    private String parkingLotId;
    private String slotId;
    private int floor;
    private int slotNo;

    public Ticket() {
    }

    public Ticket(Ticket ticket) {
        this.ticketId = ticket.getTicketId();
        this.registrationNo = ticket.getRegistrationNo();
        this.vehicleType = ticket.getVehicleType();
        this.parkingLotId = ticket.getParkingLotId();
        this.slotId = ticket.getSlotId();
        this.floor = ticket.getFloor();
        this.slotNo = ticket.getSlotNo();
    }

    public Ticket(String ticketId, String registrationNo, VehicleType vehicleType, String parkingLotId, String slotId, int floor, int slotNo) {
        this.ticketId = ticketId;
        this.registrationNo = registrationNo;
        this.vehicleType = vehicleType;
        this.parkingLotId = parkingLotId;
        this.slotId = slotId;
        this.floor = floor;
        this.slotNo = slotNo;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }
}
