package rail.persistence.dao;

public interface DaoProvider {

    TrainDao getTrainDao();

    ComponentDao getComponentDao();

    ComponentTypeDao getComponentTypeDao();

    TrainComponentDao getTrainComponentDao();

}
