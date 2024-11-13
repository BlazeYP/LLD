package splitwise.servicesImpl;

import splitwise.services.UniqueIdGeneratorService;

import java.util.UUID;

public class UniqueIdGeneratorServiceImpl implements UniqueIdGeneratorService {

    @Override
    public String getUniqueId() {
        return UUID.randomUUID().toString();
    }
}
