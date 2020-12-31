package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import rail.persistence.dao.DaoProvider;
import rail.persistence.postgresDaoImpl.PostgresDaoImplProvider;
import richrail.domain.ElectricPowerSource;
import richrail.domain.PowerSource;
import richrail.domain.Train;
import richrail.domain.Wagon;

import java.util.Optional;
import java.util.UUID;

@Transactional
public class AdministrationService {

    private final TrainService trainService;
    private final WagonService wagonService;
    private final PowerSourceService powerSourceService;
    public static UUID trainId;

    public void setTrainId(UUID trainId) {
        this.trainId = trainId;
    }

    public static UUID getTrainId() {
        return trainId;
    }

    public AdministrationService(TrainService trainService, WagonService wagonService, PowerSourceService powerSourceService){
        this.wagonService = wagonService;
        this.trainService = trainService;
        this.powerSourceService = powerSourceService;
    }

    public Train addNewTrain(String name, int weight, PowerSource powerSource){
        return this.trainService.createNewTrain(name, weight, powerSource);
    }

    public void deleteTrain(Train train){
        this.trainService.deleteTrain(train);
    }

    public Optional<PowerSource> findById(int id){
        return this.powerSourceService.findPowersource(id);
    }

    public PowerSource addNewPowersource(int maxWeight){
        // TODO: 30-12-2020 how to add new powersource
        PowerSource powerSource = new ElectricPowerSource();
        powerSource.setMaxWeight(maxWeight);
        return this.powerSourceService.savePowersource(powerSource);
    }
    public Iterable<Train> allTrains(){
        return this.trainService.getAllTrains();
    }

    public Train getTrainById(UUID id){
        return this.trainService.getTrainById(id).get();
    }

    public void updateTrain(Train train){
        this.trainService.updateTrain(train);
    }

    public Iterable<Wagon> allWagons(){
        return this.wagonService.getAllWagons();
    }

    public Iterable<PowerSource> allPowerSourcesByWeightCompatibility(int weight){
        return this.powerSourceService.getAllPowerSourcesByWeightCompatibility(weight);
    }

    public Wagon addWagon(Wagon wagon){
        return this.wagonService.addWagon(wagon);
    }

    public Iterable<Wagon> getAllWagonsByType(){

        return this.wagonService.getAllWagonTypes();
    }

}
