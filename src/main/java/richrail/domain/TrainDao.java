package richrail.domain;

import java.util.Optional;
import java.util.UUID;

public interface TrainDao {
    Train save(Train train);
    Train findByName(String name);
    Optional<Train> findById(UUID Id);
    Iterable<Train> findAll();
}
