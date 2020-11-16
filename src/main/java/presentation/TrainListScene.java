package presentation;

import application.domain.Train;
import businesslogic.parser.controllers.TrainAdministratorController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.springframework.stereotype.Controller;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class TrainListScene{
    private TrainAdministratorController trainAdministratorController;

    @FXML
    private ListView<Train> trainList;

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
