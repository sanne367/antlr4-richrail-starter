package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.TrainWagon;
import richrail.domain.Wagon;

import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TrainInfoScene {
    private AdministrationService service;

    public TrainInfoScene(AdministrationService service){
        this.service = service;
    }

    @FXML
    private ListView<TrainWagon> wagonList;

    @FXML
    private Label trainInfo;


    @FXML
    private TextArea messageText;

    public UUID id;

    public void initialize(){
        this.loadTrain();
    }

    private void loadTrain(){
        System.out.println("alle treininfo printen");
        this.id = service.getTrainId();
        Train train = service.getTrainById(this.id);
        System.out.println("De info komt van Trein" + train);
        trainInfo.setText(train.getId() + ":" + train.getName() + ":" + train.getPowerSource());
        ObservableList<TrainWagon> items = wagonList.getItems();
        System.out.println(items);
        items.clear();
        train.iterator().forEachRemaining(items::add);
    }

    public void deleteWagonFromTrain(){
        System.out.println("wagon verwijderen");
        TrainWagon selectedWagon = this.wagonList
                .getSelectionModel()
                .getSelectedItem();
        if (selectedWagon == null) {
            return;
        }
        Train train = service.getTrainById(this.id);
        System.out.println(train.getTrain_wagons());
        if(train.removeWagon(selectedWagon)){
            messageText.setText("Wagon deleted from train");
            System.out.println(train.getTrain_wagons());
            //List<TrainWagon> newWagons = train.getTrain_wagons();
            //this.service.updateTrainWagons(train.getTrain_wagons(), train.getId());
            // TODO: 2-1-2021 train update list 
            train.setTrain_wagons(train.getTrain_wagons());
            this.service.updateTrain(train);
        }else{
            messageText.setText("Failed try again");
        }
        loadTrain();
    }

    public void addWagonToTrain() throws IOException {
        service.setTrainId(this.id);
        SceneManager.loadWagonTrainScene();
    }
}
