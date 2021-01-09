package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import richrail.domain.*;

import java.util.List;
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
//    public void updateTrain(List<TrainWagon> wagons, UUID id){
//        this.trainDao.updateWagon(wagons, id);
//    }

//    public void updateTrain( UUID id, Train train){
//        this.trainDao.updateTrain(train, id);
//    }
    public Train update(Train train){

        return this.trainDao.update(train);
    }
    public Iterable<Train> getAllTrains(){

//        for(Train t : this.trainJpaRepository.findAll()){
//            System.out.println("treinrepos" + t);
//        }
        return this.trainDao.findAll();
    }

    public void duplicateTrain(Train train) throws CloneNotSupportedException{
        System.out.println("trein om te copy" + train);
        Train train1 = (Train)train.clone();
        train1.setId(UUID.randomUUID());
        System.out.println("trein copy" + train1);
        this.trainDao.save(train1);
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
