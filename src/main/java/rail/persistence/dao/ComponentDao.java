package rail.persistence.dao;

import rail.domain.Component;
import rail.domain.ComponentType;

import java.util.List;

public interface ComponentDao extends GenericDAO<Component> {
    List<Component> findByName(String name);
    List<Component> findByType(ComponentType componentType);

}
