package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import rail.persistence.dao.DaoProvider;
import rail.persistence.postgresDaoImpl.PostgresDaoImplProvider;
import richrail.domain.Train;
import richrail.domain.Wagon;

import java.util.Optional;
import java.util.UUID;

@Transactional
public class AdministrationService {

    private final TrainService trainService;
    private final WagonService wagonService;
    public static UUID trainId;

    public void setTrainId(UUID trainId) {
        this.trainId = trainId;
    }

    public static UUID getTrainId() {
        return trainId;
    }

    public AdministrationService(TrainService trainService, WagonService wagonService){
        this.wagonService = wagonService;
        this.trainService = trainService;
    }

    public Train addNewTrain(String name, int weight){
        return this.trainService.createNewTrain(name, weight);
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

}
