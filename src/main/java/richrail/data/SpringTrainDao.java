package richrail.data;

import richrail.domain.Train;
import richrail.domain.TrainDao;

import java.util.Optional;
import java.util.UUID;

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
    public Optional<Train> findById(UUID id) {
        return this.trainJpaRepository.findById(id);
    }

    @Override
    public Train findByName(String name){return null;};

    @Override
    public Iterable<Train> findAll() {
        return this.trainJpaRepository.findAll();
    }

    @Override
    public void deleteTrain(Train train) {
        this.trainJpaRepository.delete(train);
    }
}
