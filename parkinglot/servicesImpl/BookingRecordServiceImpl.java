package parkinglot.servicesImpl;

import parkinglot.exceptions.BookingServiceException;
import parkinglot.models.BookingRecords;
import parkinglot.models.BookingRow;
import parkinglot.models.Ticket;
import parkinglot.services.BookingRecordService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class BookingRecordServiceImpl implements BookingRecordService {
    private BookingRecords bookingRecords;

    public BookingRecordServiceImpl(BookingRecords bookingRecords) {
        this.bookingRecords = bookingRecords;
    }

    @Override
    public boolean addBooking(String parkingLotId, String parkingSlotId, Ticket ticket) throws BookingServiceException {
        try {
            if(BookingServiceValidator.validateBookingDetails(parkingLotId, parkingSlotId, ticket)) {
                BookingRow bookingRow = new BookingRow(parkingLotId, parkingSlotId, ticket, LocalDateTime.now(), LocalDateTime.MAX);
                ArrayList<BookingRow> bookingRows = bookingRecords.getBookingRows();
                bookingRows.add(bookingRow);
            }
        } catch (BookingServiceException e) {
            throw e;
        }
        return true;
    }

    @Override
    public BookingRecords getAllBookingRecords(String parkingLotId) {
        ArrayList<BookingRow> filteredBookingRows = new ArrayList<>();
        BookingRecords filteredBookingRecords = new BookingRecords(filteredBookingRows);
        ArrayList<BookingRow> bookingRows = this.bookingRecords.getBookingRows();
        for(BookingRow bookingRow : bookingRows) {
            if(Objects.nonNull(parkingLotId) && bookingRow.getParkingLotId().equalsIgnoreCase(parkingLotId)) {
                filteredBookingRows.add(new BookingRow(bookingRow));
            } else if(Objects.isNull(parkingLotId) || parkingLotId.isBlank()) {
                filteredBookingRows.add(new BookingRow(bookingRow));
            }
        }
        return filteredBookingRecords;
    }

    @Override
    public boolean deleteBooking(String ticketId) {
        ArrayList<BookingRow> bookingRows = this.bookingRecords.getBookingRows();
        for(BookingRow bookingRow : bookingRows) {
            if(Objects.nonNull(ticketId) && Objects.nonNull(bookingRow.getTicket()) && ticketId.equalsIgnoreCase(bookingRow.getTicket().getTicketId())) {
                bookingRows.remove(bookingRow);
            }
        }
        return true;
    }
}
