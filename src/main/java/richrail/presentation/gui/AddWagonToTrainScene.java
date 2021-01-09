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
    private GuiTrainService guiTrainService;
    private GuiWagonService guiWagonService;
    public UUID id;

    public AddWagonToTrainScene(GuiTrainService guiTrainService, GuiWagonService guiWagonService){
        this.guiTrainService = guiTrainService;
        this.guiWagonService = guiWagonService;
    }

    @FXML
    private ListView<Wagon> wagonsList;

    @FXML
    private TextArea messageText;

    @FXML
    private Label trainInfo;

    private Train train;
    public void initialize(){
        this.loadWagons();
    }

    private void loadWagons(){
        this.guiWagonService.loadWagonsBasedOnToAdd(wagonsList);
        this.guiTrainService.loadTrainInfoForLabel(trainInfo);
        this.train = this.guiTrainService.getTrainById();
    }
    
    public void addWagonToTrain(){
        System.out.println("wagon toevoegen");
        this.guiWagonService.addWagonToTrain(train, this.wagonsList.getSelectionModel().getSelectedItem(), messageText);
        loadWagons();
    }

    public void backToTrainInfo() throws IOException {
        richrail.presentation.gui.SceneManager.loadTrainInfoScene();
    }
}
