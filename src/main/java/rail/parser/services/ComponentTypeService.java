package rail.parser.services;

import rail.domain.ComponentType;
import rail.persistence.dao.ComponentTypeDao;

import java.util.List;

public class ComponentTypeService {
    private final ComponentTypeDao componentTypeDao;

    public ComponentTypeService(ComponentTypeDao componentTypeDao){
        this.componentTypeDao = componentTypeDao;
    }

    public void saveOrUpdateComponentType(ComponentType componentType){
        componentTypeDao.insert(componentType);
    }

    public List<ComponentType> getAllComponentTypes(){
        return  componentTypeDao.getAll();
    }

    public ComponentType findComponentTypeById(int id){
        return componentTypeDao.findById(id);
    }

    public List<ComponentType> getAllComponentTypesByName(String name){
        return  componentTypeDao.findByName(name);
    }


}
