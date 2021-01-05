package richrail.application;


import org.springframework.transaction.annotation.Transactional;
import richrail.domain.PowerSource;
import richrail.domain.PowerSourceDao;
import richrail.domain.PowerSourceFactory;
import richrail.domain.WeightBasedPowerSourceFactory;

import java.util.Optional;

@Transactional
public class PowerSourceService {
    private final PowerSourceDao powerSourceDao;

    public PowerSourceService(PowerSourceDao powerSourceDao){
        this.powerSourceDao = powerSourceDao;
    }

    public Iterable<PowerSource> getAllPowerSources(){
        return this.powerSourceDao.findAll();
    }

    public Iterable<PowerSource> getAllPowerSourcesByWeightCompatibility(int weight){
        return this.powerSourceDao.findAllByCompatibility(weight);
    }

    public PowerSource addNewPowersourceBasedOnWeight(int maxWeight){
        PowerSourceFactory factory = new WeightBasedPowerSourceFactory(maxWeight);
        PowerSource powerSource = factory.createPowerSource();
        return this.powerSourceDao.save(powerSource);
    }

    public Optional<PowerSource> findPowersource(int id){
        return this.powerSourceDao.findPowersourceById(id);
    }


}
