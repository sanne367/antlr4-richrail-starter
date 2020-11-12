package persistence.postgresDaoImpl;

import application.domain.Component;
import application.domain.Component;
import application.domain.ComponentType;
import persistence.dao.AbstractDaoImpl;
import persistence.dao.ComponentDao;

import javax.persistence.EntityManager;
import java.util.List;

public class ComponentPostgresDaoImpl extends AbstractDaoImpl<Component> implements ComponentDao {
    public ComponentPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }

    public List<Component> findByType(ComponentType componentType){
        List<Component> componentList = (List<Component>) em
                .createQuery("from Component where componenttype_id=" + componentType.getId()).getResultList();
        if(!componentList.isEmpty()){
            return componentList;
        }
        return null;


    }

    public List<Component> findByName(String name){
        List<Component> componentList = (List<Component>) em
                .createQuery("from Component where name=" + name).getResultList();
        if(!componentList.isEmpty()){
            return componentList;
        }
        return null;


    }
}
