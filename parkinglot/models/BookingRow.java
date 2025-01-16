package parkinglot.models;

import java.time.LocalDateTime;

public class BookingRow {
    private String parkingLotId;
    private String slotId;
    private Ticket ticket;
    private LocalDateTime valid_from_ts;
    private LocalDateTime valid_to_ts;

    public BookingRow() {
    }

    public BookingRow(BookingRow bookingRow) {
        this.parkingLotId = bookingRow.getParkingLotId();
        this.slotId = bookingRow.getSlotId();
        this.ticket = new Ticket(bookingRow.getTicket());
        this.valid_from_ts = bookingRow.getValid_from_ts();
        this.valid_to_ts = bookingRow.getValid_to_ts();
    }

    public BookingRow(String parkingLotId, String slotId, Ticket ticket, LocalDateTime valid_from_ts, LocalDateTime valid_to_ts) {
        this.parkingLotId = parkingLotId;
        this.slotId = slotId;
        this.ticket = ticket;
        this.valid_from_ts = valid_from_ts;
        this.valid_to_ts = valid_to_ts;
    }


    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getValid_from_ts() {
        return valid_from_ts;
    }

    public void setValid_from_ts(LocalDateTime valid_from_ts) {
        this.valid_from_ts = valid_from_ts;
    }

    public LocalDateTime getValid_to_ts() {
        return valid_to_ts;
    }

    public void setValid_to_ts(LocalDateTime valid_to_ts) {
        this.valid_to_ts = valid_to_ts;
    }
}
