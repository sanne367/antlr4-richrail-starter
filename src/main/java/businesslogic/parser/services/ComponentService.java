package businesslogic.parser.services;

import application.domain.Component;
import persistence.dao.ComponentDao;

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

    public Component getComponentById(int id){
        return componentDao.findById(id);
    }
}
