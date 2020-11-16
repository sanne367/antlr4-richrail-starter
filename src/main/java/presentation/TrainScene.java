package presentation;

import application.domain.Train;
import application.domain.TrainComponent;
import businesslogic.parser.controllers.TrainAdministratorController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TrainScene {
    private TrainAdministratorController trainAdministratorController;
    private Train train;

    @FXML
    private ListView<TrainComponent> trainComponentList;

    @FXML
    private Label trainInfo;

    public TrainScene(TrainAdministratorController trainAdministratorController){
        this.trainAdministratorController = trainAdministratorController;
        // TODO: 16-11-2020 pass data
        //this.train = train;
    }

    public void initialize(){
        this.loadTrainInfo();
    }

    private void loadTrainInfo(){
        this.train = trainAdministratorController.giveTrainById(9);
        trainInfo.setText("Train: " + train.getName() + " with id: " + train.getId());
        ObservableList<TrainComponent> items = this.trainComponentList.getItems();
        items.clear();
        List<TrainComponent> allTrainComponents = this.trainAdministratorController.allComponentByTrainId(this.train.getId());
        if(allTrainComponents != null){
            items.addAll(allTrainComponents);
        }
    }
}
