package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import richrail.application.AdministrationService;
import richrail.domain.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class ShowTrainPictureScene {
    private GuiTrainService guiTrainService;
    private GuiWagonService guiWagonService;

    public ShowTrainPictureScene(GuiTrainService guiTrainService, GuiWagonService guiWagonService){
        this.guiTrainService = guiTrainService;
        this.guiWagonService = guiWagonService;
    }

    @FXML
    private FlowPane trainPicture;

    @FXML
    private Label trainInfo;

    @FXML
    private ChoiceBox<Wagon> choiceWagon;

    private Train train;

    @FXML
    private TextArea messageText;

    public UUID id;

    public void initialize(){
        this.loadTrain();

    }

    private void loadTrain(){
        this.guiTrainService.loadTrainInfoForLabel(trainInfo);
        this.guiTrainService.showTrainPicture(trainPicture, messageText);
        this.guiWagonService.loadWagonsBasedOnToAdd(choiceWagon);
        this.guiWagonService.showAllWagonsImage(this.guiTrainService.getTrainById(), messageText, trainPicture);
        this.train = this.guiTrainService.getTrainById();
    }

    public void addWagonToTrain(){
        this.guiWagonService.addWagonToTrain(train, choiceWagon.getSelectionModel().getSelectedItem(),messageText);
        choiceWagon.getItems().clear();
        loadTrain();
    }

    public void deleteWagonFromTrain(){
        try{
            int idDelete = Integer.valueOf(messageText.getText().replaceAll("\\D+",""));
            for(TrainWagon trainWagon : train.getTrainWagons()){
                if(trainWagon.getWagon().getId() == idDelete) {
                    this.guiWagonService.deleteWagonFromTrain(trainWagon, train, messageText);
                    loadTrain();
                }
            }
        }catch (Exception e){
            messageText.setText(e.getMessage());
        }

    }

    public void goBackToListView() throws IOException {
        messageText.clear();
        trainPicture.getChildren().clear();
        trainInfo.setText("");
        SceneManager.loadTrainInfoScene();
    }
}
