package rail.presentation;

import rail.domain.Train;
import rail.parser.controllers.TrainAdministratorController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class TrainListScene{
    private TrainAdministratorController trainAdministratorController;

    @FXML
    private ListView<Train> trainList;

    @FXML
    private TextField inputTitle;

    public TrainListScene(TrainAdministratorController trainAdministratorController){
        this.trainAdministratorController = trainAdministratorController;
    }

    public void initialize(){
        this.loadTrains();
    }


    private void loadTrains() {
        ObservableList<Train> items = this.trainList.getItems();
        items.clear();
        List<Train> allTrains = this.trainAdministratorController.giveAllTrains();
        items.addAll(allTrains);
    }

    public void handleDelete(){
        Train selection = this.trainList
                .getSelectionModel()
                .getSelectedItem();

        if (selection == null) {
            return;
        }

        this.trainAdministratorController.deleteTrain(selection);
        this.loadTrains();
    }
    public void handleNew(){
        String title = this.inputTitle
                .getCharacters()
                .toString();

        if (title.isBlank()) {
            return;
        }
        trainAdministratorController.setTrainName(title);
        Train train = trainAdministratorController.getTrainBuilder().build();
        this.trainAdministratorController.saveTrain(train);
        this.loadTrains();
    }

    public void handleShowTrain() throws IOException {
        Train selection = this.trainList
                .getSelectionModel()
                .getSelectedItem();

        if (selection == null) {
            return;
        }

        SceneManager.showTrainInfo();
    }
}
