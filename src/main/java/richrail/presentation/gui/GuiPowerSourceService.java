package richrail.presentation.gui;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import richrail.application.AdministrationService;
import richrail.domain.PowerSource;
import richrail.domain.exception.WeightNotAllowed;

import java.awt.*;
import java.util.UUID;

public class GuiPowerSourceService {
    private AdministrationService service;
    private UUID trainId;

    public GuiPowerSourceService(AdministrationService service){
        this.service = service;
    }

    public void loadPowersources(int weight, TextArea messageText, ChoiceBox<PowerSource> choicePowersource) throws WeightNotAllowed {
        System.out.println("Print powersources compatible with train weight ");
        this.service.getLogger().info("Print powersources compatible with train weight");
        try {
            Iterable<PowerSource> allPower = service.allPowerSourcesByWeightCompatibility(weight);
            ObservableList<PowerSource> allItems = choicePowersource.getItems();
            allItems.clear();
            allPower.iterator().forEachRemaining(allItems::add);
            messageText.setText("Select powersource");
        }catch (Exception e){
            messageText.setText("No powersources compatible for given weight " + e.getMessage());
            this.service.getLogger().info("No powersources compatible for given weight");
        }
    }


}
