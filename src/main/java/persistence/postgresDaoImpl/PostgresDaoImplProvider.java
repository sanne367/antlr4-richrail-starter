package persistence.postgresDaoImpl;

import persistence.HibernateUtil;
import persistence.dao.ComponentDao;
import persistence.dao.ComponentTypeDao;
import persistence.dao.DaoProvider;
import persistence.dao.TrainDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostgresDaoImplProvider extends HibernateUtil implements DaoProvider {
    private static EntityManagerFactory entityManagerFactory;
    private TrainDao trainDao;
    private ComponentTypeDao componentTypeDao;
    private ComponentDao componentDao;

    public PostgresDaoImplProvider(){
        EntityManager entityManager = null;
        try {
            entityManagerFactory = HibernateUtil.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            trainDao = new TrainPostgresDaoImpl(entityManager);
            componentDao = new ComponentPostgresDaoImpl(entityManager);
            componentTypeDao = new ComponentTypePostgresDaoImpl(entityManager);
        }catch (Throwable ex){
            System.err.println("Failed to create entitymanager object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public TrainDao getTrainDao(){
        return trainDao;
    }

    @Override
    public ComponentDao getComponentDao() {
        return componentDao;
    }

    @Override
    public ComponentTypeDao getComponentTypeDao() {
        return componentTypeDao;
    }
}
