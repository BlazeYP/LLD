package parkinglot.exceptions;

public class BookingServiceException extends Exception{
    public BookingServiceException() {
    }

    public BookingServiceException(String message) {
        super(message);
    }
}
