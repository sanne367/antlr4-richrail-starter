package richrail.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainDao {
    Train save(Train train);
    Train findByName(String name);
    Optional<Train> findById(UUID Id);
    Iterable<Train> findAll();
    void deleteTrain(Train train);
    void updateWagon(List<TrainWagon> trainWagons, UUID id);
    Train update(Train train);
}
