package parkinglot.services;

import parkinglot.exceptions.BookingServiceException;
import parkinglot.models.BookingRecords;
import parkinglot.models.Ticket;

public interface BookingRecordService {
    boolean addBooking(String parkingLotId, String parkingSlotId, Ticket ticket) throws BookingServiceException;
    BookingRecords getAllBookingRecords(String parkingLotId);
    boolean deleteBooking(String ticketId);
}
