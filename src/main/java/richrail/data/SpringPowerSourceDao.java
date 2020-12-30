package richrail.data;

import richrail.domain.PowerSource;
import richrail.domain.PowerSourceDao;

import java.util.Optional;

public class SpringPowerSourceDao implements PowerSourceDao {
    private final PowerSourceJpaRepository powerSourceJpaRepository;

    public SpringPowerSourceDao(PowerSourceJpaRepository powerSourceJpaRepository){
        this.powerSourceJpaRepository = powerSourceJpaRepository;
    }

    @Override
    public Iterable<PowerSource> findAll() {
        return this.powerSourceJpaRepository.findAll();
    }

    @Override
    public Iterable<PowerSource> findAllByCompatibility(int weight) {
        return this.powerSourceJpaRepository.findTrainByPowerSourceAndWeightNamedParams(weight);
    }

    @Override
    public PowerSource save(PowerSource powerSource) {

        return this.powerSourceJpaRepository.save(powerSource);
    }

    @Override
    public Optional<PowerSource> findPowersourceById(int id) {
        return this.powerSourceJpaRepository.findById(id);
    }


}
