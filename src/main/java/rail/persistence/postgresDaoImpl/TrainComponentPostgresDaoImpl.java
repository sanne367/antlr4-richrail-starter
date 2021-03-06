package rail.persistence.postgresDaoImpl;

import rail.domain.TrainComponent;
import rail.persistence.dao.AbstractDaoImpl;
import rail.persistence.dao.TrainComponentDao;

import javax.persistence.EntityManager;
import java.util.List;

public class TrainComponentPostgresDaoImpl extends AbstractDaoImpl<TrainComponent> implements TrainComponentDao {
    public TrainComponentPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }


    public List<TrainComponent> findByTrainId(int id) {
        String query = "Select * from traincomponent where \"train_id\"=" + "'" + id + "'";
        @SuppressWarnings("unchecked")
        List<TrainComponent> trainComponents = (List<TrainComponent>) em
                .createNativeQuery(query, TrainComponent.class).getResultList();
        if(!trainComponents.isEmpty()){
            return trainComponents;
        }
        return null;

    }
}
