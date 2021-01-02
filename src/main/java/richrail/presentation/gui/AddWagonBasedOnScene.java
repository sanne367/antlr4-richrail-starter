package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import richrail.application.AdministrationService;
import richrail.domain.CarWagon;
import richrail.domain.CargoWagon;
import richrail.domain.PowerSource;
import richrail.domain.Wagon;

import javax.persistence.DiscriminatorValue;

public class AddWagonBasedOnScene {
    private AdministrationService service;

    @FXML
    private TextField inputNameWagon;

    @FXML
    private ChoiceBox<Wagon> choiceWagonType;

    @FXML
    private TextArea messageText;

    @FXML
    private TextField inputWeightWagon;

    @FXML
    private TextField inputNameOfGoods;

    public AddWagonBasedOnScene(AdministrationService service){
        this.service = service;
    }

    public void initialize(){
        messageText.setText("Welcome");
        loadWagonTypes();
    }

    public void loadWagonTypes(){
        Iterable<Wagon> allWagons = service.getAllWagonsByType();
        System.out.println(allWagons);
        ObservableList<Wagon> allTypes = choiceWagonType.getItems();
        allTypes.clear();
//        for(Wagon w : allWagons){
//            allTypes.add(w.getWagonType());
//        }
        allWagons.iterator().forEachRemaining(allTypes::add);
    }

    public void createNewWagon(){
        // TODO: 31-12-2020 dynamic input fields by type
        try{
            Wagon wagon = choiceWagonType.getSelectionModel().getSelectedItem();
            int wagonWeight = Integer.parseInt(this.inputWeightWagon
                    .getCharacters()
                    .toString());
            String wagonName = this.inputNameWagon
                    .getCharacters()
                    .toString();
            String wagonGoods = this.inputNameOfGoods
                    .getCharacters()
                    .toString();
            // TODO: 2-1-2021 how to make it open closed
            Wagon newWagon = null;
            if(wagon.getClass() == CargoWagon.class){
                newWagon = new CargoWagon();
                newWagon.setWagonTypeName(wagonName);
                newWagon.setWeight(wagonWeight);
                ((CargoWagon) newWagon).setNameOfGoods(wagonGoods);

            }if(wagon.getClass() == CarWagon.class){
                newWagon = new CarWagon();
                newWagon.setWagonTypeName(wagonName);
                newWagon.setWeight(wagonWeight);
                ((CarWagon) newWagon).setNameOfGoods(wagonGoods);
            } if(service.addWagon(newWagon) != null){
                messageText.setText("Wagon created");
                inputNameOfGoods.clear();
                inputNameWagon.clear();
                inputWeightWagon.clear();
            }
            else {
                messageText.setText("WagonType not supported");
                return;
            }

        }catch (Exception e){
            messageText.setText("Try again");
        }

    }


}
