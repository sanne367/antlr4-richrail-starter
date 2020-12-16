package richrail.data;

import richrail.domain.Train;
import richrail.domain.TrainDao;

import java.util.HashMap;
import java.util.Map;

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
    public Iterable<Train> findAll() {
        return trains.values();
    }
}
