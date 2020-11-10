package persistence.postgresDaoImpl;

import application.domain.Train;
import persistence.dao.AbstractDaoImpl;
import persistence.dao.TrainDao;

import javax.persistence.EntityManager;

public class TrainPostgresDaoImpl extends AbstractDaoImpl<Train> implements TrainDao {
    public TrainPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }
}
