package richrail.domain;

public interface TrainDao {
    Train save(Train train);
    Train findByName(String name);

    Iterable<Train> findAll();
}
