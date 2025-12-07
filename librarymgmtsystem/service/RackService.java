package librarymgmtsystem.service;

import java.util.UUID;

public interface RackService {
    int searchRackForBook(UUID bookCopyId);
    int getRackOfBook(UUID bookCopyId);
    void addBookToRack(UUID bookCopyId);
    void removeBookFromRack(UUID bookCopyId);
}
