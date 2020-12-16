package richrail.data;

import richrail.domain.Train;
import richrail.domain.TrainDao;

public class SpringTrainDao implements TrainDao {
    private final TrainJpaRepository trainJpaRepository;

    public SpringTrainDao(TrainJpaRepository trainJpaRepository) {
        this.trainJpaRepository = trainJpaRepository;
    }


    @Override
    public Train save(Train train) {
        return this.trainJpaRepository.save(train);
    }

    @Override
    public Train findByName(String name) {
        return null;
    }

    @Override
    public Iterable<Train> findAll() {
        return this.trainJpaRepository.findAll();
    }
}
