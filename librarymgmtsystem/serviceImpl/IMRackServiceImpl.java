package librarymgmtsystem.serviceImpl;

import librarymgmtsystem.models.RackEntry;
import librarymgmtsystem.strategies.RackAllocationStrategy;
import librarymgmtsystem.repositories.RackEntryRepository;
import librarymgmtsystem.service.RackService;

import java.util.UUID;

public class IMRackServiceImpl implements RackService {
    private final RackAllocationStrategy allocationStrategy;
    private final RackEntryRepository rackEntryRepository;

    public IMRackServiceImpl(RackAllocationStrategy allocationStrategy, RackEntryRepository rackEntryRepository) {
        this.allocationStrategy = allocationStrategy;
        this.rackEntryRepository = rackEntryRepository;
    }

    @Override
    public int searchRackForBook(UUID bookCopyId) {
        return allocationStrategy.getRack(bookCopyId);
    }

    @Override
    public int getRackOfBook(UUID bookCopyId) {
        return rackEntryRepository.getRackOfBook(bookCopyId);
    }

    @Override
    public void addBookToRack(UUID bookCopyId) {
        int rackNo = this.searchRackForBook(bookCopyId);
        RackEntry rackEntry = new RackEntry(rackNo, bookCopyId);
    }

    @Override
    public void removeBookFromRack(UUID bookCopyId) {
        rackEntryRepository.deleteRackEntryForBook(bookCopyId);
    }
}
