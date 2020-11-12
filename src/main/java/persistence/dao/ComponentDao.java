package persistence.dao;

import application.domain.Component;
import application.domain.ComponentType;

import java.util.List;

public interface ComponentDao extends GenericDAO<Component> {
    List<Component> findByName(String name);
    List<Component> findByType(ComponentType componentType);

}
