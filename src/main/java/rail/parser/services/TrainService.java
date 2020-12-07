package rail.parser.services;

import rail.domain.Train;
import rail.persistence.dao.TrainDao;

import java.util.List;

public class TrainService {
    private final TrainDao traindao;

    public TrainService(TrainDao trainDao){
        this.traindao = trainDao;
    }

    public void saveOrUpdateTrain(Train train){
        traindao.insert(train);
    }

    public void deleteTrain(Train train){
        traindao.delete(train);
    }

    public List<Train> getAllTrains(){
        return traindao.getAll();
    }

    public Train getTrainById(int id){
        return traindao.findById(id);
    }

    public List<Train> getTrainByName(String name){
        return traindao.getTrainByName(name);
    }
    //public List<Object> getTrainByNameO(String name){
//    return traindao.getTrainByNameO(name);
//}
}
