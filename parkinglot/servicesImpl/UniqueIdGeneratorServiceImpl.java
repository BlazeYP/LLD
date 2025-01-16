package parkinglot.servicesImpl;

import parkinglot.services.UniqueIdGeneratorService;

import java.util.Objects;
import java.util.UUID;

public class UniqueIdGeneratorServiceImpl implements UniqueIdGeneratorService {
    private UniqueIdGeneratorService uuidInstance;

    private UniqueIdGeneratorServiceImpl() {
    }

    public UniqueIdGeneratorService getInstance(){
        if(Objects.isNull(uuidInstance)) {
            uuidInstance = new UniqueIdGeneratorServiceImpl();
        }
        return uuidInstance;
    }

    @Override
    public UUID getUniqueId() {
        return UUID.randomUUID();
    }
}
