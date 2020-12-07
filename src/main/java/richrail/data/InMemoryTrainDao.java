package richrail.data;

import richrail.domain.Train;
import richrail.domain.TrainDao;

import java.util.Map;

public class InMemoryTrainDao implements TrainDao {
    private Map<String, Train> trains;

    @Override
    public void save(Train train) {
        // maybe use GUIDs instead of Strings for deterministic identification
        this.trains.put(train.getName(), train);
    }

    public Train findByName(String name) {
        return this.trains.get(name);
    }
}
