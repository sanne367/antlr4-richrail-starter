package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import org.slf4j.Logger;
import richrail.application.AdministrationService;
import richrail.domain.PowerSource;
import richrail.domain.PowerSourceFactory;
import richrail.domain.Train;

import java.io.IOException;
import java.util.UUID;

public class GuiTrainService {
    private AdministrationService service;
    private UUID trainId;

    public GuiTrainService(AdministrationService service){
        this.service = service;
    }

    public void loadTrainList(ListView<Train> trainList){
        System.out.println("alle treinen printen");
        service.getLogger().info("All trains");
        ObservableList<Train> items = trainList.getItems();
        items.clear();
        Iterable<Train> allTrains = service.allTrains();
        System.out.println(allTrains);
        if(allTrains != null){
            allTrains.forEach(items::add);
        }
    }

    public void loadTrainInfoForLabel(Label trainInfo){
        System.out.println("alle treininfo printen");
        service.getLogger().info("Show train info");
        Train train = getTrainById();
        System.out.println("De info komt van Trein" + train);
        service.getLogger().info("Show train info" + train);
        trainInfo.setText(
                "[ID]:" + train.getId() + " [NAME]:" + train.getName() + " [POWERSOURCE]:"
                        + train.getPowerSource() + "\n[Allowed weight]: " + train.getPowerSource().getMaxWeight()
                        + " [Current weight]: " + train.calculateWeight() + " [Budget]: " +
                        (train.getPowerSource().getMaxWeight() - train.calculateWeight()));

    }

    public Train getTrainById(){
        return service.getTrainById(this.trainId);
    }

    public void setTrainId(UUID trainId) {
        this.trainId = trainId;
    }

    public void showTrainInfo(ListView<Train> trainList, TextArea messageText) throws IOException {
        try{
            Train selection = trainList
                    .getSelectionModel()
                    .getSelectedItem();
            this.trainId = selection.getId();
        }catch (Exception e){
            messageText.setText("Select Train " + e.getMessage());
            service.getLogger().info(e.getMessage());
        }
        SceneManager.loadTrainInfoScene();
    };

    public void showTrainPicture(FlowPane trainPicture, TextArea messageText){
        trainPicture.getChildren().clear();
        ImageViewFactory powerFactory = new PowerSourceImageViewFactory(getTrainById().getPowerSource().getClass());
        try{
            ImageView imageView = powerFactory.createImageview();
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    messageText.setText("Current selection: " + imageView.getId()
                            +"\nPowersource: [Name]" + getTrainById().getPowerSource().getClass().getName());
                    System.out.println("You clicked: " + imageView.getId());
                }
            });
            String idString = String.valueOf(getTrainById().getPowerSource().getId());
            imageView.setId(idString);
            trainPicture.getChildren().add(imageView);
        }catch (Exception e){
            messageText.setText(e.getMessage());
        }

    }

    public void copyTrain(Train train) throws CloneNotSupportedException{
        service.duplicateTrain(train);
    }

    public void addNewTrain(String name, int weight, PowerSource powerSource){
        service.addNewTrain(name, weight, powerSource);
    }

    public void deleteTrain(Train train){
        service.deleteTrain(train);
    }
}
