package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import richrail.domain.*;

import java.util.Optional;
import java.util.UUID;


@Transactional
public class TrainService {
    private final TrainDao trainDao;

    public TrainService(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    public Train createNewTrain(String name, int weight, PowerSource powerSource) {
        Train train = new Train(name, weight);
        train.setPowerSource(powerSource);
        return this.trainDao.save(train);
    }
    public Train updateTrain(Train train){
        return this.trainDao.save(train);
    }
    public Iterable<Train> getAllTrains(){

//        for(Train t : this.trainJpaRepository.findAll()){
//            System.out.println("treinrepos" + t);
//        }
        return this.trainDao.findAll();
    }

    public void deleteTrain(Train train){
        this.trainDao.deleteTrain(train);
    }
    public Optional<Train> getTrainById(UUID id){
        return this.trainDao.findById(id);
    }

//
//    public void addWagonToTrain(String name, WagonDto dto) {
//
//    }
}
