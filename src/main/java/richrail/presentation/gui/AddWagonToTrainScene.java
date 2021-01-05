package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import rail.presentation.SceneManager;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.TrainWagon;
import richrail.domain.Wagon;

import java.io.IOException;
import java.util.UUID;

public class AddWagonToTrainScene {
    private AdministrationService service;
    public UUID id;

    public AddWagonToTrainScene(AdministrationService service){
        this.service = service;
    }

    @FXML
    private ListView<Wagon> wagonsList;

    @FXML
    private TextArea messageText;

    @FXML
    private Label trainInfo;

    public void initialize(){
        this.loadWagons();
    }

    private void loadWagons(){
        System.out.println("Alle wagons printen");
        //messageText.clear();
        this.id = this.service.getTrainId();
        Train train = service.getTrainById(this.id);
        trainInfo.setText("Allowed weight: " + train.getPowerSource().getMaxWeight()
                + " Current weight: " + train.calculateWeight() + " Budget: " +
        (train.getPowerSource().getMaxWeight() - train.calculateWeight()));
        ObservableList<Wagon> items = wagonsList.getItems();
        System.out.println(items);
        items.clear();
        Iterable<Wagon> allWagons = service.getAllWagonsBasedOnType();
        for(Wagon wagon : allWagons){
            if(wagon.getWagonTypeName() != null){
                items.add(wagon);
            }
        }
        //allWagons.iterator().forEachRemaining(items::add);
    }
    
    public void addWagonToTrain(){
        System.out.println("wagon toevoegen");
        Wagon selectedWagon = this.wagonsList
                .getSelectionModel()
                .getSelectedItem();
        if (selectedWagon == null) {
            return;
        }
        Train train = service.getTrainById(this.id);
        if(train.checkExistenceTrainWagon(selectedWagon)){
            if(train.addQuantity(selectedWagon)){
                messageText.setText("Wagon quantity added to Train");
            }
            else{
                messageText.setText("Failed to add wagon: allowed weight extended");
            }
        }else{
            // TODO: 1-1-2021 builder opbouw logica && exceptions ipv strings
            TrainWagon trainWagon = new TrainWagon();
            trainWagon.setTrain(train);
            trainWagon.setWagon(selectedWagon);
            if(train.addNew(trainWagon)){
                messageText.setText("New wagon added to Train");
            }else {
                messageText.setText("Failed to add new wagon: allowed weight extended");
            }
        }
        if(this.service.updateTrain(train) != null){
            messageText.setText(messageText.getText() + "\nTrain updated");
        };

        loadWagons();
    }

    public void backToTrainInfo() throws IOException {
        richrail.presentation.gui.SceneManager.loadTrainInfoScene();
    }
}
