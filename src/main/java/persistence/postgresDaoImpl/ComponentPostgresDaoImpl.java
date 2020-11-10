package persistence.postgresDaoImpl;

import application.domain.Component;
import persistence.dao.AbstractDaoImpl;
import persistence.dao.ComponentDao;

import javax.persistence.EntityManager;

public class ComponentPostgresDaoImpl extends AbstractDaoImpl<Component> implements ComponentDao {
    public ComponentPostgresDaoImpl(EntityManager entityManager){
        super(entityManager);
    }
}
