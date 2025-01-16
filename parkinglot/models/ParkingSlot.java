package parkinglot.models;

public class ParkingSlot {
    private String slotId;
    private int floor;
    private int slotNo;
    private SlotType slotType;
    private boolean isOccupied;

    public ParkingSlot() {
    }

    public ParkingSlot(String slotId, int floor, int slotNo, SlotType slotType, boolean isOccupied) {
        this.slotId = slotId;
        this.floor = floor;
        this.slotNo = slotNo;
        this.slotType = slotType;
        this.isOccupied = isOccupied;
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

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
