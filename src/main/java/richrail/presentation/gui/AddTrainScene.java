package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import richrail.application.AdministrationService;
import richrail.domain.PowerSource;
import richrail.domain.exception.WeightNotAllowed;

import java.util.UUID;


public class AddTrainScene {
    private GuiTrainService guiTrainService;
    private GuiPowerSourceService guiPowerSourceService;
    public UUID id;

    @FXML
    private TextField inputNameTrain;

    @FXML
    private ChoiceBox<PowerSource> choicePowersource;

    @FXML
    private TextArea messageText;

    @FXML
    private TextField inputWeightTrain;

    private String trainName;

    private int trainWeight;

    public AddTrainScene(GuiTrainService guiTrainService, GuiPowerSourceService guiPowerService){
        this.guiTrainService = guiTrainService;
        this.guiPowerSourceService = guiPowerService;
    }

    public void initialize(){
        messageText.setText("Welcome");
    }


    public void findPowersourceByWeight(){
        try{
            trainWeight = Integer.parseInt(this.inputWeightTrain
                    .getCharacters()
                    .toString());
            trainName = this.inputNameTrain
                    .getCharacters()
                    .toString();
        }catch (Exception e){
            messageText.setText("Please enter a valid name and number");
            return;
        }
        System.out.println(trainWeight);
        System.out.println(trainName);
        this.guiPowerSourceService.loadPowersources(trainWeight, messageText, choicePowersource);
        if(choicePowersource.getItems() == null){
            WeightNotAllowed e = new WeightNotAllowed("No powersources compatible for given weight");
            messageText.setText(e.getMessage());
        }
    }

    public void createNewTrain(){
        try{
            PowerSource powerSource = choicePowersource.getSelectionModel().getSelectedItem();
            if(powerSource == null || this.trainWeight == 0 || this.trainName == null){
                messageText.setText("Please fill in all input fields");
                return;
            }
                this.guiTrainService.addNewTrain(this.trainName, this.trainWeight,powerSource);
                messageText.setText("Train created");
                inputNameTrain.clear();
                this.trainName = null;
                this.trainWeight = 0;
                powerSource = null;
                inputWeightTrain.clear();
                choicePowersource.getItems().clear();

        }catch (Exception e){
            messageText.setText("Something went wrong please try again" + e.getMessage());
        }
    }



}
