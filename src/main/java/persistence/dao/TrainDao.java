package persistence.dao;

import application.domain.Train;
import application.domain.TrainComponent;

import java.util.List;

public interface TrainDao extends GenericDAO<Train> {
    List<Train> getTrainByName(String name);
    //List<Object> getTrainByNameO(String name);
}
