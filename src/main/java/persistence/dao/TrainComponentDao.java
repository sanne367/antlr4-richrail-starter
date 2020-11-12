package persistence.dao;

import application.domain.TrainComponent;

import java.util.List;

public interface TrainComponentDao extends GenericDAO<TrainComponent> {
    List<TrainComponent> findByTrainId(int id);
}
