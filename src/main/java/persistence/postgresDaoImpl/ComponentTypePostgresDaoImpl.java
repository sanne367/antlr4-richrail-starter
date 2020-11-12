package persistence.postgresDaoImpl;

import application.domain.ComponentType;
import persistence.dao.AbstractDaoImpl;
import persistence.dao.ComponentDao;
import persistence.dao.ComponentTypeDao;

import javax.persistence.EntityManager;
import java.util.List;

public class ComponentTypePostgresDaoImpl extends AbstractDaoImpl<ComponentType> implements ComponentTypeDao {
    public ComponentTypePostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }

    public List<ComponentType> findByName(String name){
        List<ComponentType> componentTypeList = (List<ComponentType>) em
               .createQuery("from componenttype where name=" + name).getResultList();
            if(!componentTypeList.isEmpty()){
            }
            return null;


    }
}

