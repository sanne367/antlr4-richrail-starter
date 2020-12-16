package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import rail.persistence.dao.DaoProvider;
import rail.persistence.postgresDaoImpl.PostgresDaoImplProvider;
import richrail.domain.Train;

@Transactional
public class AdministrationService {

    private final TrainService trainService;


    public AdministrationService(TrainService trainService){

        this.trainService = trainService;
    }

    public Train addNewTrain(String name, int weight){
        return this.trainService.createNewTrain(name, weight);
    }

    public Iterable<Train> allTrains(){
        return this.trainService.getAllTrains();
    }
}
