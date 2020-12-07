package rail.persistence.dao;

import rail.domain.ComponentType;

import java.util.List;

public interface ComponentTypeDao extends GenericDAO<ComponentType> {
    List<ComponentType> findByName(String name);
}
