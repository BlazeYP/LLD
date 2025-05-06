package parkinglot.servicesImpl;

import parkinglot.exceptions.ParkingLotRecordServiceException;
import parkinglot.models.*;
import parkinglot.services.ParkingLotRecordService;
import parkinglot.services.UniqueIdGeneratorService;
import parkinglot.utilities.ParkingSystemMapper;

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
    public void createParkingLot(String parkingLotName, String parkingLotAddress, int floorCount, Map<Integer, List<String>> floors) throws ParkingLotRecordServiceException {
        String parkingLotId = uniqueIdGeneratorService.getUniqueId().toString();

        ParkingLot parkingLot = new ParkingLot();
        // TODO: 17/01/2025  Add validations

        //Setting fields
        parkingLot.setParkingLotId(parkingLotId);
        parkingLot.setParkingLotName(parkingLotName);
        parkingLot.setParkingLotAddress(parkingLotAddress);
        parkingLot.setFloorCount(floorCount);

        //Adding parking floors
        ArrayList<ParkingFloor> parkingFloors = new ArrayList<>();
        for(int floorIdx=0; floorIdx < floorCount; floorIdx++ ) {
            ParkingFloor parkingFloor = new ParkingFloor(floorIdx, null);
            parkingFloors.add(parkingFloor);
        }

        //Adding slots to each given floor
        for(Map.Entry<Integer, List<String>> floor : floors.entrySet()) {
            int floorNumber = floor.getKey();
            List<String> floorSlotTypes = floor.getValue();
            ArrayList<ParkingSlot> parkingSlots = null;
            if(Objects.nonNull(floorSlotTypes) && floorSlotTypes.size() != 0) {
                parkingSlots = new ArrayList<>();
                //Making parking slots
                for(int slotIdx=0; slotIdx < floorSlotTypes.size(); slotIdx++) {
                    String slotType = floorSlotTypes.get(slotIdx);
                    SlotType slotTypeEnum = ParkingSystemMapper.mapSlotTypeStringToSlotType(slotType);
                    if(Objects.isNull(slotTypeEnum)) {
                        throw new ParkingLotRecordServiceException("Slot type not recognised!!");
                    }
                    String parkingSlotId = generateParkingSlotId(parkingLotId, floorNumber, slotIdx);
                    ParkingSlot parkingSlot = new ParkingSlot(parkingSlotId, floorNumber+1, slotIdx+1, slotTypeEnum, false);
                    parkingSlots.add(parkingSlot);
                }
            }
            parkingFloors.get(floorNumber).setParkingSlots(parkingSlots);
        }
        parkingLot.setParkingFloors(parkingFloors);
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
    public void addParkingSlots(String parkingLotId, int floorNo, int slots, List<String> slotTypes) throws ParkingLotRecordServiceException {
        ParkingLot selectedparkingLot = getParkingLot(parkingLotId, parkingLotRecords.getParkingLots());
        if(Objects.nonNull(selectedparkingLot)) {
            //Todo: add validation for floor number
            ParkingFloor parkingFloor = selectedparkingLot.getParkingFloors().get(floorNo);
            ArrayList<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
            int currentSlotCount = parkingFloor.getParkingSlots().size();
            for(int slotIdx=0; slotIdx < slots; slotIdx++){
                SlotType slotType = ParkingSystemMapper.mapSlotTypeStringToSlotType(slotTypes.get(slotIdx));
                if(Objects.isNull(slotType)) {
                    throw new ParkingLotRecordServiceException("Slot type is invalid!!");
                }
                int newSlotNumber = currentSlotCount + slotIdx;
                String parkingSlotId = generateParkingSlotId(selectedparkingLot.getParkingLotId(), floorNo,newSlotNumber);
                ParkingSlot parkingSlot = new ParkingSlot(parkingSlotId, floorNo, newSlotNumber, slotType, false);
                parkingSlots.add(parkingSlot);
            }
        } else {
            throw new ParkingLotRecordServiceException("No such parking Lot exist!!");
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
