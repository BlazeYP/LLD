package parkinglot.servicesImpl;

import parkinglot.exceptions.ParkingLotRecordServiceException;
import parkinglot.models.*;
import parkinglot.services.ParkingLotRecordService;
import parkinglot.services.UniqueIdGeneratorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static parkinglot.utilities.Constants.ID_CONCATENATE_STR;

public class ParkingLotRecordServiceImpl implements ParkingLotRecordService {
    private ParkingLotRecords parkingLotRecords;
    private UniqueIdGeneratorService uniqueIdGeneratorService;

    public ParkingLotRecordServiceImpl(ParkingLotRecords parkingLotRecords, UniqueIdGeneratorService uniqueIdGeneratorService) {
        this.parkingLotRecords = parkingLotRecords;
        this.uniqueIdGeneratorService = uniqueIdGeneratorService;
    }

    @Override
    public void createParkingLot(String parkingLotName, String parkingLotAddress, int floorCount, Map<Integer, List<String>> slots) throws ParkingLotRecordServiceException {
        String parkingLotId = uniqueIdGeneratorService.getUniqueId().toString();
        ParkingLot parkingLot = new ParkingLot();
        // TODO: 17/01/2025  Add validations
        //Setting fields
        parkingLot.setParkingLotId(parkingLotId);
        parkingLot.setParkingLotName(parkingLotName);
        parkingLot.setParkingLotAddress(parkingLotAddress);
        parkingLot.setFloorCount(floorCount);

        ArrayList<ParkingFloor> parkingFloors = new ArrayList<>();
        //Adding parking floors
        for(int floorIdx=0; floorIdx < floorCount; floorIdx++ ) {
            ParkingFloor parkingFloor = new ParkingFloor(floorIdx+1, null);
            ArrayList<String> parkingSlotTypeList = (ArrayList<String>) slots.get(floorIdx);

            if(Objects.nonNull(parkingSlotTypeList) && parkingSlotTypeList.size() != 0) {
                parkingFloor.setParkingSlots(new ArrayList<>());
                for(int slotIdx=0; slotIdx < parkingSlotTypeList.size(); slotIdx++) {
                    SlotType slotTypeEnum = null;
                    String slotType = parkingSlotTypeList.get(slotIdx);
                    switch(slotType.toUpperCase()) {
                        case "S":
                            slotTypeEnum = SlotType.SMALL;
                            break;
                        case "M":
                            slotTypeEnum = SlotType.MEDIUM;
                            break;
                        case "L":
                            slotTypeEnum = SlotType.LARGE;
                            break;
                        default:
                            throw new ParkingLotRecordServiceException("Invalid slot type supplied at floor %d and slot position %d".formatted(floorIdx+1, slotIdx+1));

                    }
                    String parkingSlotId = generateParkingSlotId(parkingLotId, floorIdx, slotIdx);
                    ParkingSlot parkingSlot = new ParkingSlot(parkingSlotId, floorIdx+1, slotIdx+1, slotTypeEnum, false);
                    parkingFloor.getParkingSlots().add(parkingSlot);
                }
            }
            parkingLot.setParkingFloors(parkingFloors);
        }
        parkingLotRecords.getParkingLots().add(parkingLot);
    }

    private String generateParkingSlotId(String parkingLotId, int floorIdx, int slotIdx) {
        return parkingLotId + ID_CONCATENATE_STR + floorIdx + ID_CONCATENATE_STR + slotIdx;
    }

    @Override
    public void addFloors(String parkingLotId, int floors) throws ParkingLotRecordServiceException {
        // TODO: 17/01/2025 Add validation of parkingLotId
        ParkingLot selectedParkingLot = getParkingLot(parkingLotId, parkingLotRecords.getParkingLots());
        if(Objects.nonNull(selectedParkingLot)) {
            int lastFloorNo = selectedParkingLot.getFloorCount();
            for (int count = 1; count <= floors; count++) {
                ParkingFloor parkingFloor = new ParkingFloor(lastFloorNo + count, null);
                selectedParkingLot.getParkingFloors().add(parkingFloor);
            }
        } else {
            throw new ParkingLotRecordServiceException("No such parkingLot exist!!");
        }
    }

    private ParkingLot getParkingLot(String parkingLotId, ArrayList<ParkingLot> parkingLots) {
        ParkingLot selectedParkingLot = null;
        for(ParkingLot parkingLot : parkingLots) {
            if(parkingLotId.equalsIgnoreCase(parkingLot.getParkingLotId())){
                selectedParkingLot = parkingLot;
            }
        }
        return selectedParkingLot;
    }

    @Override
    public void addParkingSlots(String parkingLotId, int floorNo, int slots, List<SlotType> slotTypes) throws ParkingLotRecordServiceException {
        ParkingLot selectedparkingLot = getParkingLot(parkingLotId, parkingLotRecords.getParkingLots());
        if(Objects.nonNull(selectedparkingLot)) {

        } else {
            throw new ParkingLotRecordServiceException("No such parkingLot exist!!");
        }
    }

    @Override
    public void deleteParkingLot(String parkingLotId) {

    }

    @Override
    public void deleteParkingFloor(String parkingLotId, int floorNumber) {

    }

    @Override
    public void deleteParkingSlot(String parkingLotId, int floorNumber, int slotNumber) {

    }

    @Override
    public void updateParkingSlotType(String parkingLotId, int floorNumber, int slotNumber, SlotType slotType) {

    }
}
