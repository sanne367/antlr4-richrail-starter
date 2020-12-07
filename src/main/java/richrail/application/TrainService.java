package richrail.application;

import richrail.domain.Train;
import richrail.domain.TrainDao;

public class TrainService {
    private TrainDao trainDao;

    public TrainService(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    public Train createNewTrain(String name) {
        Train train = new Train(name);
        this.trainDao.save(train);
        return train;
    }

//    public void addWagonToTrain(String name, WagonDto dto) {
//
//    }
}
