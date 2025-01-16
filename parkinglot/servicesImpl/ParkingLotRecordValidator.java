package parkinglot.servicesImpl;

import parkinglot.exceptions.ParkingLotRecordServiceException;

import java.util.Objects;

public class ParkingLotRecordValidator {

    public static boolean validateParkingId(String parkingLotId) throws ParkingLotRecordServiceException {
        if(Objects.isNull(parkingLotId)) {
            throw new ParkingLotRecordServiceException("ERROR | Parking lot id is null");
        } if (parkingLotId.isBlank()) {
            throw new ParkingLotRecordServiceException("ERROR | Parking lot id is blank");
        } return true;
    }
}
