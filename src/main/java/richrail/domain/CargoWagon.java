package richrail.domain;

import java.util.UUID;

public class CargoWagon implements Wagon {
    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }
}
