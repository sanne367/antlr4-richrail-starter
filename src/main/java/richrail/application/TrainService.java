package richrail.application;

import org.springframework.transaction.annotation.Transactional;
import richrail.domain.*;


@Transactional
public class TrainService {
    private final TrainDao trainDao;

    public TrainService(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    public Train createNewTrain(String name, int weight) {
        Train train = new Train(name, weight);
        PowerSource powerSource = new ElectricPowerSource();
        train.setPowerSource(powerSource);
        Wagon wagon = new CargoWagon();
        train.add(wagon);
        return this.trainDao.save(train);
    }

    public Iterable<Train> getAllTrains(){

//        for(Train t : this.trainJpaRepository.findAll()){
//            System.out.println("treinrepos" + t);
//        }
        return this.trainDao.findAll();
    }

//
//    public void addWagonToTrain(String name, WagonDto dto) {
//
//    }
}
