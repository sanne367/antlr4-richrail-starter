package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import richrail.application.AdministrationService;
import richrail.domain.Train;
import richrail.domain.Wagon;

public class DeleteWagonScene {
    private GuiWagonService service;

    public DeleteWagonScene(GuiWagonService service) {
        this.service = service;
    }

    @FXML
    private ListView<Wagon> wagonList;

    @FXML
    private TextArea messageText;
    public void initialize(){
        this.loadWagonsToDelete();
    }

    private void loadWagonsToDelete(){
        System.out.println("Print all wagons");
        messageText.setText("Warning: wagon will be deleted from all trains");
        service.loadWagonsBasedOnToAdd(wagonList);
    }

    public void deleteWagon(){
        System.out.println("Wagon verwijderen");
        try{
            service.deleteWagon(this.wagonList.getSelectionModel().getSelectedItem());
            messageText.setText("Wagon deleted");
            loadWagonsToDelete();
        }catch (Exception e){
            messageText.setText("Failed, try again" + e.getMessage());
        }

    }
}
