package rail.persistence.dao;

import rail.domain.Train;

import java.util.List;

public interface TrainDao extends GenericDAO<Train> {
    List<Train> getTrainByName(String name);
    //List<Object> getTrainByNameO(String name);
}
