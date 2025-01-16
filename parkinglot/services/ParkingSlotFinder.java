package parkinglot.services;

import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSlot;

public interface ParkingSlotFinder {
    ParkingSlot getFreeParkingSlot(ParkingLot parkingLot);
}
