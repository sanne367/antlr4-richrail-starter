package richrail.presentation.gui;

import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import richrail.application.AdministrationService;
import richrail.domain.*;

import java.io.IOException;


public class TrainScene {
    private AdministrationService service;

    public TrainScene(AdministrationService service) {
        this.service = service;
    }

    @FXML
    private ListView<Train> trainList;

    @FXML
    private TextArea messageText;

    @FXML
    private Label trainInfo;

    public void initialize(){
//        service.addNewPowersource(300);
//        Wagon wagon = new CarWagon();
//        service.addWagon(wagon);
        this.loadTrains();
    }


    private void loadTrains(){
        System.out.println("alle treinen printen");

        ObservableList<Train> items = trainList.getItems();
        items.clear();
//        Train train = service.addNewTrain("test2", 2563);
  //      System.out.println(train);
        Iterable<Train> allTrains = service.allTrains();

        System.out.println(allTrains);
        if(allTrains != null){
            allTrains.forEach(items::add);
        }
    }

    public void showTrainInfo() throws IOException {
        try{
            Train selection = this.trainList
                    .getSelectionModel()
                    .getSelectedItem();
            this.service.setTrainId(selection.getId());
        }catch (Exception e){
            messageText.setText("Select Train");
        }

        SceneManager.loadTrainInfoScene();
    }
}
