package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
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
    private ChoiceBox<Wagon> choiceWagon;


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
        trainPicture.getChildren().clear();
        messageText.clear();
        trainInfo.setText("[ID]:" + train.getId() + " [NAME]:" + train.getName() + " [POWERSOURCE]:"
                + train.getPowerSource() + "\n[Allowed weight]: " + train.getPowerSource().getMaxWeight()
                + " [Current weight]: " + train.calculateWeight() + " [Budget]: " +
                (train.getPowerSource().getMaxWeight() - train.calculateWeight()));
        // TODO: 3-1-2021 goede manier van importen & goede manier keuze & make img clickable
        loadTrainImages(train);
        loadWagonsToAdd();

    }

    public void loadWagonsToAdd(){
        Iterable<Wagon> allWagons = service.getAllWagonsBasedOnType();
        if(allWagons != null){
            ObservableList<Wagon> allItems = choiceWagon.getItems();
            allItems.clear();
            allWagons.iterator().forEachRemaining(allItems::add);
        }
    }
    public void loadTrainImages(Train train){
        String filePath = "C:/Users/sanne/Documents/GitHub/antlr4-richrail-starter/src/main/resources/richrail/presentation/gui/";
        String windPowersourceTrain = "wind2.PNG";
        String electricPowersourceTrain = "electric.PNG";
        String petroleumPowersourceTrain = "petroleum2.PNG";
        String carWagon = "car.PNG";
        String cargoWagon = "cargo.PNG";
        String personWagon = "person.PNG";
        try{
            if(train.getPowerSource().getClass() == WindPowerSource.class){
                String powersourceWind = filePath + windPowersourceTrain;
                addPowersourceImage(powersourceWind, train.getPowerSource());
            }
            if(train.getPowerSource().getClass() == ElectricPowerSource.class){
                String powersourceElectric = filePath + electricPowersourceTrain;
                addPowersourceImage(powersourceElectric, train.getPowerSource());
            }
            if(train.getPowerSource().getClass() == PetroleumPowerSource.class){
                String powersourcePetroleum = filePath + petroleumPowersourceTrain;
                addPowersourceImage(powersourcePetroleum, train.getPowerSource());
            }
            for(TrainWagon trainWagon : train.getTrain_wagons()){
                if (trainWagon.getWagon().getClass() == CarWagon.class){
                    String carWagonWagon = filePath + carWagon;
                    int quantity = trainWagon.getQuantity();
                    for(int i = quantity; i>0 ; i--){
                        addWagonImage(carWagonWagon, trainWagon);
                    }
                }
                else if (trainWagon.getWagon().getClass() == CargoWagon.class){
                    String cargoWagonWagon = filePath + cargoWagon;
                    int quantity = trainWagon.getQuantity();
                    for(int i = quantity; i>0 ; i--){
                        addWagonImage(cargoWagonWagon, trainWagon);
                    }
                } else if (trainWagon.getWagon().getClass() == PersonWagon.class){
                    String personWagonWagon = filePath + personWagon;
                    int quantity = trainWagon.getQuantity();
                    for(int i = quantity; i>0 ; i--){
                        addWagonImage(personWagonWagon, trainWagon);
                    }
                }
            }
        }catch (Exception e){
            messageText.setText(e.toString());
        }
    }


    public void addWagonImage(String filePath, TrainWagon wagon) throws Exception {
        FileInputStream inputstream = new FileInputStream(filePath);
        Image image = new Image(inputstream);
        ImageView imageView = new ImageView(image);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                messageText.setText("Current selection: " + imageView.getId()
                        + "\nWagon: [Name]" + wagon.getWagon().getWagonTypeName());
                System.out.println("You clicked: " + imageView.getId());
            }
        });
        String idString = String.valueOf(wagon.getWagon().getId());
        imageView.setId(idString);
        trainPicture.getChildren().add(imageView);
    }

    public void addPowersourceImage(String filePath, PowerSource powerSource) throws Exception {
        FileInputStream inputstream = new FileInputStream(filePath);
        Image image = new Image(inputstream);
        ImageView imageView = new ImageView(image);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                messageText.setText("Current selection: " + imageView.getId()
                +"\nPowersource: [Name]" + powerSource.getClass().getName());
                System.out.println("You clicked: " + imageView.getId());
            }
        });
        String idString = String.valueOf(powerSource.getId());
        imageView.setId(idString);
        trainPicture.getChildren().add(imageView);
    }

    public void deleteWagonFromTrain(){
        int idDelete = Integer.valueOf(messageText.getText().replaceAll("\\D+",""));
        messageText.setText("Deleting " + idDelete);
        Train train = service.getTrainById(this.id);
        for(TrainWagon trainWagon : train.getTrain_wagons()){
            if(trainWagon.getWagon().getId() == idDelete){
                if(train.removeWagon(trainWagon)){
                    this.service.updateTrain(train);
                    messageText.setText("Wagon deleted from train");
                    loadTrain();
                }else{
                    messageText.setText("Failed try again");
                }
            }
        }
            messageText.setText("Select wagon to delete");
            loadTrain();
    }

    public void addWagonToTrain(){
        Train train = service.getTrainById(this.id);
        System.out.println("wagon toevoegen");
        Wagon selectedWagon = this.choiceWagon
                .getSelectionModel()
                .getSelectedItem();
        if (selectedWagon == null) {
            return;
        }
        if(train.checkExistenceTrainWagon(selectedWagon)){
            if(train.addQuantity(selectedWagon)){
                messageText.setText("Wagon quantity added to Train");
            }
            else{
                messageText.setText("Failed to add wagon: allowed weight extended");
            }
        }else{
            // TODO: 1-1-2021 builder opbouw logica && exceptions ipv strings
            TrainWagon trainWagon = new TrainWagon();
            trainWagon.setTrain(train);
            trainWagon.setWagon(selectedWagon);
            if(train.addNew(trainWagon)){
                messageText.setText("New wagon added to Train");
            }else {
                messageText.setText("Failed to add new wagon: allowed weight extended");
            }
        }
        if(this.service.updateTrain(train) != null){
            messageText.setText(messageText.getText() + "\nTrain updated");
            loadTrain();
        };
    }

    public void goBackToListView() throws IOException {
        messageText.clear();
        trainPicture.getChildren().clear();
        trainInfo.setText("");
        SceneManager.loadTrainInfoScene();
    }
}
