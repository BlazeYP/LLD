package librarymgmtsystem.models;

import java.util.UUID;

public class RackEntry {
    private int rackId;
    private UUID bookId;

    public RackEntry(int rackId, UUID bookId) {
        this.rackId = rackId;
        this.bookId = bookId;
    }

    public int getRackId() {
        return rackId;
    }

    public void setRackId(int rackId) {
        this.rackId = rackId;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }
}
