package richrail.data;

import richrail.domain.Train;
import richrail.domain.TrainDao;
import richrail.domain.TrainWagon;

import java.util.*;

public class InMemoryTrainDao implements TrainDao {
    private Map<String, Train> trains = new HashMap<>();

    @Override
    public Train save(Train train) {
        // maybe use GUIDs instead of Strings for deterministic identification
        return this.trains.put(train.getName(), train);
    }

    public Train findByName(String name) {
        return this.trains.get(name);
    }

    @Override
    public Optional<Train> findById(UUID Id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Train> findAll() {
        return trains.values();
    }

    @Override
    public void deleteTrain(Train train) {

    }

    @Override
    public void updateWagon(List<TrainWagon> trainWagons, UUID id) {

    }

    @Override
    public Train update(Train train) {
        return null;
    }
}
