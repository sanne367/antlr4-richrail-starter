package persistence.postgresDaoImpl;

import application.domain.TrainComponent;
import persistence.dao.AbstractDaoImpl;
import persistence.dao.TrainComponentDao;

import javax.persistence.EntityManager;
import java.util.List;

public class TrainComponentPostgresDaoImpl extends AbstractDaoImpl<TrainComponent> implements TrainComponentDao {
    public TrainComponentPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }


    public List<TrainComponent> findByTrainId(int id) {
        List<TrainComponent> trainComponents = (List<TrainComponent>) em
                .createQuery("from traincomponent where train_id=" + id).getResultList();
        if(!trainComponents.isEmpty()){
            return trainComponents;
        }
        return null;

    }
}
