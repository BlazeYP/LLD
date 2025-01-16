package parkinglot;

import parkinglot.models.BookingRecords;
import parkinglot.models.ParkingLotRecords;
import parkinglot.models.VehicleRecords;

import java.util.ArrayList;

public class Main {
    private static VehicleRecords vehicleRecords;
    private static TicketRecords ticketRecords;
    private static ParkingLotRecords parkingLotRecords;
    private static BookingRecords bookingRecords;

    private static void dbSetup() {
        vehicleRecords = new VehicleRecords(new ArrayList<>());
        ticketRecords = new TicketRecords(new ArrayList<>());
        parkingLotRecords = new ParkingLotRecords(new ArrayList<>());
        bookingRecords = new BookingRecords(new ArrayList<>());
    }

    private static void serviceSetUp() {
    }

    public static void main(String[] args) {
        dbSetup();
        serviceSetUp();

    }




}
