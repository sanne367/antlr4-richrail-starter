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
    private AdministrationService service;

    public DeleteTrainScene(AdministrationService service) {
        this.service = service;
    }

    @FXML
    private ListView<Train> trainList;

    @FXML
    private TextArea messageText;

    public void initialize(){
        this.loadTrainsToDelete();
    }


    private void loadTrainsToDelete(){
        System.out.println("alle treinen printen");
        ObservableList<Train> items = trainList.getItems();
        items.clear();
        Iterable<Train> allTrains = service.allTrains();
        System.out.println(allTrains);
        if(allTrains != null){
            allTrains.forEach(items::add);
        }
    }

    public void deleteTrain(){
        System.out.println("Trein verwijderen");
        Train train = this.trainList.getSelectionModel().getSelectedItem();
        if(train == null){
            return;
        }
        try{
            service.deleteTrain(train);
            messageText.setText("Train deleted");
            loadTrainsToDelete();
        }catch (Exception e){
            messageText.setText("Failed, try again");
        }

    }
}
