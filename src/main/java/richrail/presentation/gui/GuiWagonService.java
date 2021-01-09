package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import richrail.application.AdministrationService;
import richrail.domain.*;

import java.util.UUID;

public class GuiWagonService {
    private AdministrationService service;
    private UUID trainId;

    public GuiWagonService(AdministrationService service){
        this.service = service;
    }

    public void loadWagonsFromTrain(ListView<TrainWagon> wagonList, Train train){
        System.out.println("All wagons from train" + train);
        service.getLogger().info("All wagons from train" + train);
        ObservableList<TrainWagon> items = wagonList.getItems();
        items.clear();
        for(TrainWagon wagon : train.getTrainWagons())
            if (wagon.getQuantity() >= 1) items.add(wagon);
    }

    public void loadWagonHistoryFromTrain(ListView<TrainWagon> wagonList, Train train){
        System.out.println("All wagon history from train" + train);
        service.getLogger().info("All wagon history from train" + train);
        ObservableList<TrainWagon> items = wagonList.getItems();
        items.clear();
        for(TrainWagon wagon : train.getTrainWagons())
            if (wagon.getQuantity() == 0) items.add(wagon);
    }

    public void addNewWagon(Wagon wagon, String wagonGoods, int wagonWeight, String wagonName){
        WagonFactory wagonFactory = new TypeBasedWagonFactory(wagon, wagonGoods, wagonWeight, wagonName);
        service.addWagon(wagonFactory.createWagon());
    }

    public void addWagonToTrain(Train train, Wagon selectedWagon, TextArea messageText){
        if(train.checkExistenceTrainWagon(selectedWagon)){
            try{
                train.addQuantity(selectedWagon);
                messageText.setText("Wagon quantity added to Train");
            }catch (Exception e){
                messageText.setText("Failed to add wagon: " + e.getMessage());
            }
        }else{
            TrainWagon trainWagon = new TrainWagon();
            trainWagon.setTrain(train);
            trainWagon.setWagon(selectedWagon);
            try{
                train.addNew(trainWagon);
            }catch (Exception e){
                messageText.setText("Failed to add new wagon: " + e.getMessage());
            }
        }
        if(this.service.updateTrain(train) != null){
            messageText.setText(messageText.getText() + "\nTrain updated");
        };
    }

    public void deleteWagonFromTrain(TrainWagon selectedWagon, Train train, TextArea messageText){
        System.out.println("Delete wagon");
        service.getLogger().info("Delete wagon");
        try{
            System.out.println("Trainwagons before delete " + train.getTrainWagons());
            this.service.getLogger().info("Trainwagons before delete " + train.getTrainWagons());
            train.removeWagon(selectedWagon);
            messageText.setText("Wagon deleted");
            this.service.updateTrain(train);
        }catch (Exception e){
            messageText.setText("Failed try again: " + e.getMessage());
            this.service.getLogger().info(e.getMessage());
        }
    }

    public void loadWagonsBasedOnToAdd(ChoiceBox<Wagon> choiceWagon){
        Iterable<Wagon> allWagons = service.getAllWagonsBasedOnType();
        System.out.println(allWagons);
        if(allWagons != null){
            ObservableList<Wagon> allItems = choiceWagon.getItems();
            allItems.clear();
            allWagons.iterator().forEachRemaining(allItems::add);
            //choiceWagon.setValue(allWagons.iterator().next());
        }
    }

    public void loadWagonsBasedOnToAdd(ListView<Wagon> choiceWagon){
        Iterable<Wagon> allWagons = service.getAllWagonsBasedOnType();
        if(allWagons != null){
            ObservableList<Wagon> allItems = choiceWagon.getItems();
            allItems.clear();
            allWagons.iterator().forEachRemaining(allItems::add);
        }
    }
    public void loadWagonsGeneric(ChoiceBox<Wagon> choiceWagon){
        Iterable<Wagon> allWagons = service.getAllWagonsByType();
        if(allWagons != null){
            ObservableList<Wagon> allItems = choiceWagon.getItems();
            allItems.clear();
            allWagons.iterator().forEachRemaining(allItems::add);
        }
    }

    public void showAllWagonsImage(Train train, TextArea messageText, FlowPane trainPicture){
        for(TrainWagon trainWagon : train.getTrainWagons()){
            int quantity = trainWagon.getQuantity();
            for(int i = quantity; i>0 ; i--){
                loadWagonImg(trainWagon, messageText, trainPicture);
            }
        }
    }

    public void loadWagonImg(TrainWagon wagon, TextArea messageText, FlowPane trainPicture){
        ImageViewFactory imageViewFactory = new WagonImageViewFactory(wagon.getWagon().getClass());
        try {
            ImageView imageView = imageViewFactory.createImageview();
            imageView.setId(String.valueOf(wagon.getWagon().getId()));
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    messageText.setText("Current selection: " + imageView.getId()
                            + "\nWagon: [Name]" + wagon.getWagon().getWagonTypeName());
                    System.out.println("You clicked: " + imageView.getId());
                }
            });
            trainPicture.getChildren().add(imageView);
        }catch (Exception e){
            messageText.setText("Failed " + e.getMessage());
        }
    }

    public void deleteWagon(Wagon wagon){
        service.deleteWagon(wagon);
    }
}
