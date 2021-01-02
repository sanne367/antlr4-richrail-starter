package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.Wagon;

public class WagonScene {
    private AdministrationService service;

    public WagonScene(AdministrationService service) {
        this.service = service;
    }

    @FXML
    private ListView<Wagon> wagonList;

    @FXML
    private Label wagonInfo;
    public void initialize(){
        this.loadWagons();
    }

    private void loadWagons(){
        System.out.println("Print all wagons");

        ObservableList<Wagon> items = wagonList.getItems();
        items.clear();
        Iterable<Wagon> allWagons = service.getAllWagonsBasedOnType();

        if(allWagons != null){
            allWagons.forEach(items::add);
        }

    }

    public void showWagonInfo(){
        // TODO: 2-1-2021  nice to have: change wagon
    }
}
