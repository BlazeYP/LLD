package parkinglot.servicesImpl;

import parkinglot.exceptions.BookingServiceException;
import parkinglot.models.Ticket;

import java.util.Objects;

public class BookingServiceValidator {

    public static boolean validateBookingDetails(String parkingLotId, String parkingSlotId, Ticket ticket) throws BookingServiceException {
        if(Objects.isNull(parkingLotId)) {
            throw new BookingServiceException("ERROR | Parking lot id is null");
        } if (Objects.isNull(parkingSlotId)) {
            throw new BookingServiceException("ERROR | Parking slot id is null");
        } if (Objects.isNull(ticket) || Objects.isNull(ticket.getTicketId())) {
            throw new BookingServiceException("ERROR | Ticket is null");
        }
        return true;
    }
}
