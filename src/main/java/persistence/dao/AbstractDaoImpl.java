package persistence.dao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractDaoImpl<T> implements GenericDAO<T> {
    protected EntityManager em;
    protected Class<T> type;

    public AbstractDaoImpl(EntityManager entityManager){
        this.em = entityManager;
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void insert(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        //em.close();
    }

    @Override
    public void update(T entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(T entity){
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
//        em.close();
    }

    @Override
    public T findById(int id){
        T entity = (T) em.find(type, id);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll(){
        List<T> entities = (List<T>) em.createQuery("from " + type.getName()).getResultList();
        return entities;
    }

}
