package librarymgmtsystem.strategies;

import java.util.UUID;

public interface RackAllocationStrategy {
    int getRack(UUID bookCopyId);
}
