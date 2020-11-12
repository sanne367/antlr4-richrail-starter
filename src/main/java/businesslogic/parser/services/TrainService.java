package businesslogic.parser.services;

import application.domain.Train;
import persistence.dao.TrainDao;

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
}
