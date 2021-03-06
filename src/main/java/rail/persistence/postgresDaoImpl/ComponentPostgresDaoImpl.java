package rail.persistence.postgresDaoImpl;

import rail.domain.Component;
import rail.domain.ComponentType;
import rail.persistence.dao.AbstractDaoImpl;
import rail.persistence.dao.ComponentDao;

import javax.persistence.EntityManager;
import java.util.List;

public class ComponentPostgresDaoImpl extends AbstractDaoImpl<Component> implements ComponentDao {
    public ComponentPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }

    public List<Component> findByType(ComponentType componentType){
        String query = "Select * from Component where componenttype_id=" + "'" + componentType.getId() + "'";
        @SuppressWarnings("unchecked")
        List<Component> componentList = (List<Component>) em
                .createNativeQuery(query, Component.class).getResultList();
        if(!componentList.isEmpty()){
            return componentList;
        }
        return null;
    }

    public List<Component> findByName(String name){
        String query = "Select * from Component where \"name\"=" + "'" + name + "'";
        @SuppressWarnings("unchecked")
        List<Component> componentList = (List<Component>) em
                .createNativeQuery(query, Component.class).getResultList();
        if(!componentList.isEmpty()){
            return componentList;
        }
        return null;


    }
}
