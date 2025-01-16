package parkinglot.models;

import java.util.ArrayList;

public class BookingRecords {
    private ArrayList<BookingRow> bookingRows;

    public BookingRecords() {
    }

    public BookingRecords(ArrayList<BookingRow> bookingRows) {
        this.bookingRows = bookingRows;
    }

    public ArrayList<BookingRow> getBookingRows() {
        return bookingRows;
    }

    public void setBookingRows(ArrayList<BookingRow> bookingRows) {
        this.bookingRows = bookingRows;
    }
}
