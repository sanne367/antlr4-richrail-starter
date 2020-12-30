package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import rail.presentation.SceneManager;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.TrainWagon;
import richrail.domain.Wagon;

import java.io.IOException;
import java.util.UUID;

public class WagonsScene {
    private AdministrationService service;
    public UUID id;

    public WagonsScene(AdministrationService service){
        this.service = service;
    }

    @FXML
    private ListView<Wagon> wagonsList;

    public void initialize(){
        this.loadWagons();
    }

    private void loadWagons(){
        System.out.println("Alle wagons printen");
        this.id = this.service.getTrainId();
        ObservableList<Wagon> items = wagonsList.getItems();
        System.out.println(items);
        items.clear();
        Iterable<Wagon> allWagons = service.allWagons();
        allWagons.iterator().forEachRemaining(items::add);
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
        TrainWagon trainWagon = new TrainWagon();
        trainWagon.setWagon(selectedWagon);
        train.add(trainWagon);
        this.service.updateTrain(train);
        loadWagons();
        // TODO: 28-12-2020 check weight  
    }

    public void backToTrainInfo() throws IOException {
        richrail.presentation.gui.SceneManager.loadTrainInfoScene();
    }
}
