package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.TrainWagon;

import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.UUID;

public class TrainInfoScene {
    private GuiTrainService guiTrainService;
    private GuiWagonService guiWagonService;

    public TrainInfoScene(GuiTrainService guiTrainservice, GuiWagonService guiWagonService){
        this.guiWagonService = guiWagonService;
        this.guiTrainService = guiTrainservice;
    }

    @FXML
    private ListView<TrainWagon> wagonList;

    @FXML
    private Label trainInfo;

    @FXML
    private TextArea messageText;

    private Train train;

    public void initialize(){
        this.loadTrain();
    }

    private void loadTrain(){
        this.train = this.guiTrainService.getTrainById();
       this.guiTrainService.loadTrainInfoForLabel(trainInfo);
       this.guiWagonService.loadWagonsFromTrain(wagonList, this.train);

    }

    public void deleteWagonFromTrain(){
        this.guiWagonService.deleteWagonFromTrain(wagonList.getSelectionModel().getSelectedItem(), this.train, messageText);
        loadTrain();
    }

    public void addWagonToTrain() throws IOException {
        this.guiTrainService.setTrainId(train.getId());
        SceneManager.loadWagonTrainScene();
    }

    public void goToTrainPictureView() throws IOException{
        SceneManager.loadTrainPictureScene();
    }
}
