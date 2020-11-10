package persistence.postgresDaoImpl;

import application.domain.ComponentType;
import persistence.dao.AbstractDaoImpl;
import persistence.dao.ComponentDao;
import persistence.dao.ComponentTypeDao;

import javax.persistence.EntityManager;

public class ComponentTypePostgresDaoImpl extends AbstractDaoImpl<ComponentType> implements ComponentTypeDao {
    public ComponentTypePostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }
}
