package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.Wagon;

public class WagonScene {
    private GuiWagonService service;

    public WagonScene(GuiWagonService service) {
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
       service.loadWagonsBasedOnToAdd(wagonList);
    }
}
