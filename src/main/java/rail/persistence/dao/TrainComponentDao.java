package rail.persistence.dao;

import rail.domain.TrainComponent;

import java.util.List;

public interface TrainComponentDao extends GenericDAO<TrainComponent> {
    List<TrainComponent> findByTrainId(int id);
}
