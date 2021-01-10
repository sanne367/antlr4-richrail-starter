package richrail.presentation.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import richrail.application.AdministrationService;
import richrail.domain.*;

import java.io.IOException;


public class TrainScene {
    private GuiTrainService guiTrainService;
    private AdministrationService service;

    public TrainScene(GuiTrainService service, AdministrationService service2) {
        this.service = service2;
        this.guiTrainService = service;
    }

    @FXML
    private ListView<Train> trainList;

    @FXML
    private TextArea messageText;

    public void initialize(){
        //addGenericDataToDatabase();
        this.guiTrainService.loadTrainList(this.trainList);
    }

    public void addGenericDataToDatabase(){
        this.service.addPowersource(40);
        this.service.addPowersource(2000);
        this.service.addPowersource(10000);
        Wagon wagon1 = new PersonWagon();
        Wagon wagon2 = new CarWagon();
        Wagon wagon3 = new CargoWagon();
        this.service.addWagon(wagon1);
        this.service.addWagon(wagon2);
        this.service.addWagon(wagon3);
    }

    public void showTrainInfo() throws IOException {
       this.guiTrainService.showTrainInfo(trainList, messageText);
    }

    public void duplicateTrain() throws CloneNotSupportedException{
        try {
            this.guiTrainService.copyTrain(trainList.getSelectionModel().getSelectedItem());
            messageText.setText("Train duplicated");
            this.trainList.getItems().clear();
            this.guiTrainService.loadTrainList(this.trainList);
        }catch (Exception e){
            messageText.setText(e.getMessage());
        }

    }

}
