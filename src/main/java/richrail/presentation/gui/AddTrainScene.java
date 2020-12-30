package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import richrail.application.AdministrationService;
import richrail.domain.PowerSource;


public class AddTrainScene {
    private AdministrationService service;

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


    public AddTrainScene(AdministrationService service){
        this.service = service;
    }

    public void initialize(){
        messageText.setText("Welcome");
        //service.addNewPowersource(4000);
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
        loadPowersources(trainWeight);
//        if (trainName.isBlank()) {
//            messageText.setText("Please enter a valid name");
//            return;
//        }
//        if (trainWeight == 0){
//            messageText.setText("Please enter a valid weight");
//            return;
//        }
//        else if(!trainName.isBlank() && trainWeight>0){
//            loadPowersources(trainWeight);
//        }

    }

    public void createNewTrain(){
        try{
        PowerSource powerSource = choicePowersource.getSelectionModel().getSelectedItem();
        if(service.addNewTrain(this.trainName, this.trainWeight,service.findById(powerSource.getId()).get()) != null){
            messageText.setText("Train created");
            inputNameTrain.clear();
            inputWeightTrain.clear();
            choicePowersource.getItems().clear();
            return;
        }}catch (Exception e){
            messageText.setText("Something went wrong please try again");
        }
    }

    public void loadPowersources(int weight){
        System.out.println("Print powersources compatible with train weight ");
        Iterable<PowerSource> allPower = service.allPowerSourcesByWeightCompatibility(weight);
        if(allPower != null){
            ObservableList<PowerSource> allItems = choicePowersource.getItems();
            allItems.clear();
            allPower.iterator().forEachRemaining(allItems::add);
            messageText.setText("Select powersource");
        }else{
            messageText.setText("No powersources compatible for given weight ");

        }
    }

}
