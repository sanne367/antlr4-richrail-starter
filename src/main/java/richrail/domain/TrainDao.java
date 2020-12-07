package richrail.domain;

public interface TrainDao {
    void save(Train train);
    Train findByName(String name);
}
