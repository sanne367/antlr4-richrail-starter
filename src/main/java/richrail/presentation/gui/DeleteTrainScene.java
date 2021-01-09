package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import richrail.application.AdministrationService;
import richrail.domain.Train;

public class DeleteTrainScene {
    private GuiTrainService service;

    public DeleteTrainScene(GuiTrainService service) {
        this.service = service;
    }

    @FXML
    private ListView<Train> trainList;

    @FXML
    private TextArea messageText;

    public void initialize(){
        loadTrainsToDelete();
    }


    private void loadTrainsToDelete(){
        this.service.loadTrainList(trainList);
    }

    public void deleteTrain(){
        System.out.println("Trein verwijderen");
        try{
            service.deleteTrain(this.trainList.getSelectionModel().getSelectedItem());
            messageText.setText("Train deleted");
            loadTrainsToDelete();
        }catch (Exception e){
            messageText.setText("Failed, try again" + e.getMessage());
        }

    }
}
