package richrail.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import rail.persistence.dao.DaoProvider;
import rail.persistence.postgresDaoImpl.PostgresDaoImplProvider;
import richrail.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public class AdministrationService {

    private final TrainService trainService;
    private final WagonService wagonService;
    private final PowerSourceService powerSourceService;
    private static final Logger logger = LoggerFactory.getLogger(AdministrationService.class);
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

    public void deleteWagon(Wagon wagon){this.wagonService.deleteWagon(wagon);}
    public void deleteTrain(Train train){
        this.trainService.deleteTrain(train);
    }

    public Optional<PowerSource> findById(int id){
        return this.powerSourceService.findPowersource(id);
    }

    public void duplicateTrain(Train train) throws CloneNotSupportedException{
        this.trainService.duplicateTrain(train);
    }

    public Iterable<Train> allTrains(){
        return this.trainService.getAllTrains();
    }

    public Train getTrainById(UUID id){
        return this.trainService.getTrainById(id).get();
    }

//    public void updateTrainWagons(List<TrainWagon> wagons, UUID id){
//        this.trainService.updateTrain(wagons, id);
//    }
    public Train updateTrain(Train train){
        return this.trainService.update(train);
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
    public Iterable<Wagon> getAllWagonsBasedOnType(){

        return this.wagonService.getAllWagonBasedOnTYpe();
    }

    public void addPowersource(int weight){
        this.powerSourceService.addNewPowersourceBasedOnWeight(weight);
    }

    public Logger getLogger(){
        return logger;
    }
}
