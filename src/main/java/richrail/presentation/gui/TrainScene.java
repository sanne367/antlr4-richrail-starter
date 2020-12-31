package richrail.presentation.gui;

import com.sun.javafx.iio.ios.IosDescriptor;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import richrail.application.AdministrationService;
import richrail.domain.Train;

import java.io.IOException;


public class TrainScene {
    private AdministrationService service;

    public TrainScene(AdministrationService service) {
        this.service = service;
    }

    @FXML
    private ListView<Train> trainList;

    @FXML
    private Label trainInfo;

    @FXML
    private TextField nameNew;

    @FXML
    private TextField weightNew;


    public void initialize(){
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

//    public void handleNew(){
//        String name = this.nameNew
//                .getCharacters()
//                .toString();
//        System.out.println(name);
//        int weight = Integer.parseInt(this.weightNew
//                .getCharacters()
//                .toString());
//        System.out.println(weight);
//
//        if (name.isBlank() || weight == 0) {
//            nameNew.clear();
//            weightNew.clear();
//            this.loadTrains();
//        }
//
//        Train train = service.addNewTrain(name, weight);
//        System.out.println(train);
//        this.loadTrains();
//    }

    public void showTrainInfo() throws IOException {
        Train selection = this.trainList
                .getSelectionModel()
                .getSelectedItem();
        this.service.setTrainId(selection.getId());
        SceneManager.loadTrainInfoScene();
    }
}
