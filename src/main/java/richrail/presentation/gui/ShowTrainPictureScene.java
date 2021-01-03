package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import richrail.application.AdministrationService;
import richrail.domain.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class ShowTrainPictureScene {
    private AdministrationService service;

    public ShowTrainPictureScene(AdministrationService service){
        this.service = service;
    }

    @FXML
    private FlowPane trainPicture;

    @FXML
    private Label trainInfo;


    @FXML
    private TextArea messageText;

    public UUID id;

    public void initialize(){
        this.loadTrain();
    }

    private void loadTrain(){
        System.out.println("alle treininfo printen");
        this.id = service.getTrainId();
        Train train = service.getTrainById(this.id);
        System.out.println("De info komt van Trein" + train);
        trainInfo.setText(train.getId() + ":" + train.getName() + ":" + train.getPowerSource());

        // TODO: 3-1-2021 goede manier van importen & goede manier keuze & make img clickable
        String filePath = "C:/Users/sanne/Documents/GitHub/antlr4-richrail-starter/src/main/resources/richrail/presentation/gui/";
        String windPowersourceTrain = "windPowersource.PNG";
        String electricPowersourceTrain = "electricPowersource.PNG";
        String carWagon = "car.PNG";
        String cargoWagon = "cargo.PNG";
        try{
            if(train.getPowerSource().getClass() == WindPowerSource.class){
                String powersourceWind = filePath + windPowersourceTrain;
                addImage(powersourceWind);
            }
            if(train.getPowerSource().getClass() == ElectricPowerSource.class){
                String powersourceElectric = filePath + electricPowersourceTrain;
                addImage(powersourceElectric);
            }
            for(TrainWagon trainWagon : train.getTrain_wagons()){
                if (trainWagon.getWagon().getClass() == CarWagon.class){
                    String carWagonWagon = filePath + carWagon;
                    int quantity = trainWagon.getQuantity();
                    for(int i = quantity; i>0 ; i--){
                        addImage(carWagonWagon);
                    }
                }
                else if (trainWagon.getWagon().getClass() == CargoWagon.class){
                    String cargoWagonWagon = filePath + cargoWagon;
                    int quantity = trainWagon.getQuantity();
                    for(int i = quantity; i>0 ; i--){
                        addImage(cargoWagonWagon);
                    }
                }
            }

        }catch (Exception e){
            messageText.setText(e.toString());
        }



    }

    public void addImage(String filePath) throws Exception{
        FileInputStream inputstream = new FileInputStream(filePath);
        Image image = new Image(inputstream);
        //ImageView imageView = new ImageView(image);
        trainPicture.getChildren().add(new ImageView(image));
    }

    public void goBackToListView() throws IOException {
        messageText.clear();
        trainPicture.getChildren().clear();
        trainInfo.setText("");
        SceneManager.loadTrainInfoScene();
    }
}
