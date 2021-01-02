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
    private AdministrationService service;

    public DeleteWagonScene(AdministrationService service) {
        this.service = service;
    }

    @FXML
    private ListView<Wagon> wagonList;

    @FXML
    private Label wagonInfo;

    @FXML
    private TextArea messageText;
    public void initialize(){
        this.loadWagonsToDelete();
    }

    private void loadWagonsToDelete(){
        System.out.println("Print all wagons");
        messageText.setText("Warning: wagon will be deleted from all trains");

        ObservableList<Wagon> items = wagonList.getItems();
        items.clear();
        Iterable<Wagon> allWagons = service.getAllWagonsBasedOnType();

        if(allWagons != null){
            allWagons.forEach(items::add);
        }

    }

    public void deleteWagon(){
        System.out.println("Wagon verwijderen");
        Wagon wagon = this.wagonList.getSelectionModel().getSelectedItem();
        if(wagon == null){
            return;
        }
        try{
            // TODO: 2-1-2021 delete wagon + records in one
            service.deleteWagon(wagon);
            messageText.setText("Wagon deleted");
            loadWagonsToDelete();
        }catch (Exception e){
            messageText.setText("Failed, try again");
        }

    }
}
