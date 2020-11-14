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
    public List<Component> giveComponentByTypeId(ComponentType componentType){
        return componentService.getComponentByTypeId(componentType);
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

//    public Object getTrainByName(String name){
//        return trainService.getTrainByNameO(name).get(0);
//    }
//    public Train getTrainByName(String name){
//        return trainService.getTrainByName(name).get(0);
//    }
    public List<Train> getTrainByName(String name){
        return trainService.getTrainByName(name);
    }

    public void setTrainComponentToTrain(Component newComponent, int trainId){
        List<TrainComponent> allTrainComponentsByTrain = allComponentByTrainId(trainId);
        System.out.println(allTrainComponentsByTrain);
        if(allTrainComponentsByTrain != null) {
            for (TrainComponent trainComponent : allTrainComponentsByTrain) {
                if (trainComponent.getComponent().equals(newComponent)) {
                    int oldQuantity = trainComponent.getQuantity();
                    trainComponent.setQuantity(oldQuantity + 1);
                    trainComponentService.saveOrUpdateTrainComponent(trainComponent);
                }
            }
        }else{
            TrainComponent newTrainComponent = new TrainComponent();
            newTrainComponent.setComponent(newComponent);
            newTrainComponent.setTrain(trainService.getTrainById(trainId));
            newTrainComponent.setQuantity(1);
            trainComponentService.saveOrUpdateTrainComponent(newTrainComponent);
        }

    }
    public void deleteTrainComponentFromTrain(Component component, int trainId){
        List<TrainComponent> allTrainComponentsByTrain = allComponentByTrainId(trainId);
        for(TrainComponent trainComponent : allTrainComponentsByTrain){
            if(trainComponent.getComponent().equals(component)) {
                trainComponentService.deleteTrainComponent(trainComponent);
            }
        }
    }
    public List<TrainComponent> allComponentByTrainId(int id){
        return trainComponentService.getTrainComponentsByTrainId(id);
    }
    public List<TrainComponent> allTrainComponents(){
        return trainComponentService.getTrainComponents();
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
