package rail.parser.services;

import rail.domain.TrainComponent;
import rail.persistence.dao.TrainComponentDao;

import java.util.List;

public class TrainComponentService {
    private final TrainComponentDao trainComponentDao;

    public TrainComponentService(TrainComponentDao trainComponentDao){
        this.trainComponentDao = trainComponentDao;
    }

    public void saveOrUpdateTrainComponent(TrainComponent trainComponent){
        trainComponentDao.insert(trainComponent);
    }

    public void deleteTrainComponent(TrainComponent trainComponent){
        trainComponentDao.delete(trainComponent);
    }

    public List<TrainComponent> getTrainComponents(){
        return trainComponentDao.getAll();
    }

    public List<TrainComponent> getTrainComponentsByTrainId(int id){
        return trainComponentDao.findByTrainId(id);
    }

    public TrainComponent getTrainComponentById(int id){
        return trainComponentDao.findById(id);
    }
}
