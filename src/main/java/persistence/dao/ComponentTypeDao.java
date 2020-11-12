package persistence.dao;

import application.domain.ComponentType;

import java.util.List;

public interface ComponentTypeDao extends GenericDAO<ComponentType> {
    List<ComponentType> findByName(String name);
}
