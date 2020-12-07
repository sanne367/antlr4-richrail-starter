package rail.parser.services;

import rail.domain.Component;
import rail.domain.ComponentType;
import rail.persistence.dao.ComponentDao;

import java.util.List;

public class ComponentService {
    private final ComponentDao componentDao;

    public ComponentService(ComponentDao componentDao){
        this.componentDao = componentDao;
    }

    public void saveOrUpdateComponent(Component component){
        componentDao.insert(component);
    }

    public List<Component> getAllComponents(){
        return componentDao.getAll();
    }

    public List<Component> getComponentByName(String name){
        return componentDao.findByName(name);
    }
    public List<Component> getComponentByTypeId(ComponentType componentType){
        return componentDao.findByType(componentType);
    }

    public Component getComponentById(int id){
        return componentDao.findById(id);
    }

}
