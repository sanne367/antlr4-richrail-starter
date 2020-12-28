package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import richrail.application.AdministrationService;
import richrail.domain.Train;
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
    private ListView<Wagon> wagonList;

    @FXML
    private Label trainInfo;

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
        ObservableList<Wagon> items = wagonList.getItems();
        System.out.println(items);
        items.clear();
        train.iterator().forEachRemaining(items::add);
    }

    public void deleteWagonFromTrain(){
        System.out.println("wagon verwijderen");
        Wagon selectedWagon = this.wagonList
                .getSelectionModel()
                .getSelectedItem();
        if (selectedWagon == null) {
            return;
        }
        Train train = service.getTrainById(this.id);
        train.remove(selectedWagon);
        this.service.updateTrain(train);
        loadTrain();
    }

    public void addWagonToTrain() throws IOException {
        service.setTrainId(this.id);
        SceneManager.loadWagonTrainScene();
    }
}
