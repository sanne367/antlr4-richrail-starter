package businesslogic.parser.controllers;

import application.domain.Component;
import application.domain.ComponentType;
import application.domain.Train;
import application.domain.TrainComponent;
import businesslogic.parser.services.ComponentService;
import businesslogic.parser.services.ComponentTypeService;
import businesslogic.parser.services.TrainComponentService;
import businesslogic.parser.services.TrainService;
import persistence.dao.DaoProvider;
import persistence.postgresDaoImpl.PostgresDaoImplProvider;

import java.util.List;

public class TrainAdministratorController {
    private final TrainService trainService;
    private final TrainComponentService trainComponentService;
    private final ComponentTypeService componentTypeService;
    private final ComponentService componentService;

    private final DaoProvider daoProvider = new PostgresDaoImplProvider();
    private final Train.TrainBuilder trainBuilder;

    public TrainAdministratorController(){
        trainComponentService = new TrainComponentService(daoProvider.getTrainComponentDao());
        trainService = new TrainService(daoProvider.getTrainDao());
        componentService = new ComponentService(daoProvider.getComponentDao());
        componentTypeService = new ComponentTypeService(daoProvider.getComponentTypeDao());

        this.trainBuilder = Train.builder();
    }

    public List<Train> giveAllTrains(){
        return trainService.getAllTrains();
    }

    public List<ComponentType> giveAllComponentTypes(){
        return componentTypeService.getAllComponentTypes();
    }

    public List<Component> giveComponentByName(String name){
        return componentService.getComponentByName(name);
    }
    public Component giveComponentByTypeId(ComponentType componentType){
        return componentService.getComponentByTypeId(componentType).get(0);
    }

    public List<Component> giveAllComponents(){
        return componentService.getAllComponents();
    }

    public void setTrainName(String name){
        trainBuilder.name(name);
    }

//    public void setTrainComponents(List<TrainComponent> allTrainComponents){
////        trainBuilder.setAllTrainComponents(allTrainComponents);
////    }

    public Train getTrainByName(String name){
        return trainService.getTrainByName(name).get(0);
    }

    public void setTrainComponentToTrain(Component newComponent, int trainId){
        List<TrainComponent> allTrainComponentsByTrain = allComponentByTrainId(trainId);
        for(TrainComponent trainComponent : allTrainComponentsByTrain){
            if(trainComponent.getTheComponent().equals(newComponent)) {
                int oldQuantity = trainComponent.getQuantity();
                trainComponent.setQuantity(oldQuantity + 1);
                trainComponentService.saveOrUpdateTrainComponent(trainComponent);
            }
        }
        TrainComponent newTrainComponent = new TrainComponent();
        newTrainComponent.setTheComponent(newComponent);
        newTrainComponent.setTheTrain(trainService.getTrainById(trainId));
        newTrainComponent.setQuantity(1);
        trainComponentService.saveOrUpdateTrainComponent(newTrainComponent);
    }
    public void deleteTrainComponentFromTrain(Component component, int trainId){
        List<TrainComponent> allTrainComponentsByTrain = allComponentByTrainId(trainId);
        for(TrainComponent trainComponent : allTrainComponentsByTrain){
            if(trainComponent.getTheComponent().equals(component)) {
                trainComponentService.deleteTrainComponent(trainComponent);
            }
        }
    }
    public List<TrainComponent> allComponentByTrainId(int id){
        Train train = trainService.getTrainById(id);
        return trainComponentService.getTrainComponentsByTrainId(train.getId());
    }
    public Train buildTrain(){
        return trainBuilder.build();
    }

    public Train.TrainBuilder getTrainBuilder(){
        return this.trainBuilder;
    }

    public void saveTrain(Train train){
        trainService.saveOrUpdateTrain(train);
    }

    public void deleteTrain(Train train){
        trainService.deleteTrain(train);
    }

    public Train giveTrainById(int id){
        return trainService.getTrainById(id);
    }

    public List<ComponentType> allComponentTypesByName(String name){
        return componentTypeService.getAllComponentTypesByName(name);
    }

    public ComponentType getComponenttypeById(int id){
        return componentTypeService.findComponentTypeById(id);
    }
    public void saveComponentType(ComponentType componentType){
        componentTypeService.saveOrUpdateComponentType(componentType);
    }

    public void saveComponent(Component component){
        componentService.saveOrUpdateComponent(component);
    }




}
