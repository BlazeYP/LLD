package parkinglot.services;

import parkinglot.exceptions.ParkingLotRecordServiceException;
import parkinglot.models.SlotType;

import java.util.List;
import java.util.Map;

public interface ParkingLotRecordService {
    // CRUD services for parking lots
    void createParkingLot(String parkingLotName, String parkingLotAddress, int floorCount, Map<Integer, List<String>> slots) throws ParkingLotRecordServiceException;
    void addFloors(String parkingLotId, int floors) throws ParkingLotRecordServiceException;
    void addParkingSlots(String parkingLotId, int floorNo, int slots, List<SlotType> slotTypes) throws ParkingLotRecordServiceException;
    void deleteParkingLot(String parkingLotId);
    void deleteParkingFloor(String parkingLotId, int floorNumber);
    void deleteParkingSlot(String parkingLotId, int floorNumber, int slotNumber);
    void updateParkingSlotType(String parkingLotId, int floorNumber, int slotNumber, SlotType slotType);
}
