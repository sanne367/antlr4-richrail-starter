package rail.persistence.postgresDaoImpl;

import rail.domain.ComponentType;
import rail.persistence.dao.AbstractDaoImpl;
import rail.persistence.dao.ComponentTypeDao;

import javax.persistence.EntityManager;
import java.util.List;

public class ComponentTypePostgresDaoImpl extends AbstractDaoImpl<ComponentType> implements ComponentTypeDao {
    public ComponentTypePostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }

    public List<ComponentType> findByName(String name){
        String query = "Select * from Componenttype where \"name\"=" + "'" + name + "'";
        @SuppressWarnings("unchecked")
        List<ComponentType> componentTypeList = (List<ComponentType>) em
               .createNativeQuery(query, ComponentType.class).getResultList();
            if(!componentTypeList.isEmpty()){
                return componentTypeList;
            }
            return null;


    }
}

