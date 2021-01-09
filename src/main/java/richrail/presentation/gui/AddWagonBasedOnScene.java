package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import richrail.application.AdministrationService;
import richrail.domain.*;

import javax.persistence.DiscriminatorValue;

public class AddWagonBasedOnScene {
    private GuiWagonService service;

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

    public AddWagonBasedOnScene(GuiWagonService service){
        this.service = service;
    }

    public void initialize(){
        messageText.setText("Welcome");
        this.service.loadWagonsGeneric(choiceWagonType);
    }

    public void createNewWagon(){
        try{
            int wagonWeight = Integer.parseInt(this.inputWeightWagon
                    .getCharacters()
                    .toString());
            String wagonName = this.inputNameWagon
                    .getCharacters()
                    .toString();
            String wagonGoods = this.inputNameOfGoods
                    .getCharacters()
                    .toString();
            service.addNewWagon(choiceWagonType.getSelectionModel().getSelectedItem(), wagonGoods, wagonWeight, wagonName);
                messageText.setText("Wagon created");
                inputNameOfGoods.clear();
                inputNameWagon.clear();
                inputWeightWagon.clear();

        }catch (Exception e){
            messageText.setText("Failed" + e.getMessage());
        }
    }
}
