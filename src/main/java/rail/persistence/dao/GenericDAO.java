package rail.persistence.dao;

import java.util.List;

public interface GenericDAO<T> {
    T findById(int id);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
    void insert(T entity);
}
