package rail.persistence.postgresDaoImpl;

import rail.domain.Train;
import rail.persistence.dao.AbstractDaoImpl;
import rail.persistence.dao.TrainDao;

import javax.persistence.EntityManager;
import java.util.List;

public class TrainPostgresDaoImpl extends AbstractDaoImpl<Train> implements TrainDao {
    public TrainPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }

//    public List<Train> getTrainByName(String name){
//        //String query = "Select from train where name=" + name;
//        @SuppressWarnings("unchecked")
//        List<Train> trainList = (List<Train>) em
//                //.createNativeQuery(query).getResultList();
//                .createQuery("from Train where name=" + name).getResultList();
//        if(!trainList.isEmpty()){
//            return trainList;
//        }
//        return null;
//    }

    public List<Train> getTrainByName(String name){
        String query = "Select * from Train where \"name\"="+ "'" + name +"'";
        @SuppressWarnings("unchecked")
        List<Train> trainList = (List<Train>) em
                .createNativeQuery(query, Train.class).getResultList();
        if(!trainList.isEmpty()){
            return trainList;
        }
        return null;
    }
}
