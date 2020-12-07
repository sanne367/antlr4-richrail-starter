package rail.presentation;

import rail.domain.Component;
import rail.domain.Train;
import rail.parser.controllers.TrainAdministratorController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TrainComponentScene {
    private TrainAdministratorController trainAdministratorController;

    @FXML
    private ListView<Component> componentList;

    @FXML
    private ListView<Train> trainList;

    @FXML
    private TextField inputTitle;

    public TrainComponentScene(TrainAdministratorController trainAdministratorController){
        this.trainAdministratorController = trainAdministratorController;
        // TODO: 16-11-2020 pass data
        //this.train = train;
    }

    public void initialize(){
        this.loadInfo();
    }

    private void loadInfo() {
        ObservableList<Train> items = this.trainList.getItems();
        items.clear();
        List<Train> allTrains = this.trainAdministratorController.giveAllTrains();
        items.addAll(allTrains);

        ObservableList<Component> items2 = this.componentList.getItems();
        items2.clear();
        List<Component> allComponents = this.trainAdministratorController.giveAllComponents();
        items2.addAll(allComponents);
    }

    public void handleNew(){
        Train selection = this.trainList
                .getSelectionModel()
                .getSelectedItem();

        Component select = this.componentList
                .getSelectionModel()
                .getSelectedItem();

        if (selection == null || select == null){
            return;
        }
        this.trainAdministratorController.setTrainComponentToTrain(select, selection);
        this.loadInfo();
    }

    public void handleDelete(){

    }

}
