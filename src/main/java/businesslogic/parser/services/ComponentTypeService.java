package businesslogic.parser.services;

import application.domain.ComponentType;
import persistence.dao.ComponentTypeDao;

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


}
