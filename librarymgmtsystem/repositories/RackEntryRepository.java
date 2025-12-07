package librarymgmtsystem.repositories;

import librarymgmtsystem.models.RackEntry;

import java.util.UUID;

public interface RackEntryRepository {
    void addRackEntry(RackEntry rackEntry);
    void deleteRackEntryForBook(UUID bookId);
    int getRackOfBook(UUID bookCopyId);
}
