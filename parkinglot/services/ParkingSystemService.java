package parkinglot.services;

import parkinglot.models.SlotType;
import parkinglot.models.Ticket;
import parkinglot.models.VehicleType;

import java.util.List;
import java.util.Map;

public interface ParkingSystemService {
    // CRUD services for parking lots
    boolean createParkingLot(String parkingLotId);
    boolean addFloors(String parkingLotId, int floors);
    List<String> addParkingSlots(String parkingLotId, int floorNo, int slots, List<SlotType> slotTypes);
    boolean deleteParkingLot(String parkingLotId);
    boolean deleteParkingFloor(String parkingLotId, int floorNumber);
    boolean deleteParkingSlot(String parkingLotId, int floorNumber, int slotNumber);
    boolean updateParkingSlotType(String parkingLotId, int floorNumber, int slotNumber, SlotType slotType);

    // Parking services of parking lot
    Ticket parkVehicle(String registrationNo, String color, String vehicleType);
    boolean unParkVehicle(String ticketId);
    int displayFreeSlot(VehicleType vehicleType);
    Map<Integer, Integer> displayFreeSlotFloorWise(VehicleType vehicleType);
    Map<Integer, Integer> displayOccupiedSlotFloorWise(VehicleType vehicleType);
}
