package richrail.presentation.gui;

import javafx.application.HostServices;
import javafx.application.HostServices.*;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class WelcomeScene {
    @FXML
    private void goToTrainScene() throws IOException {
        SceneManager.loadTrainScene();
    }

    @FXML
    private void goToAddTrainScene() throws IOException{
        SceneManager.loadAddTrainScene();
    }

    @FXML
    private void goToDeleteTrainScene() throws IOException{
        SceneManager.loadDeleteTrainScene();
    }
    @FXML
    private void goToDeleteWagonScene() throws IOException{
        SceneManager.loadDeleteWagonScene();
    }

    @FXML
    private void goToAddWagonBasedOnScene() throws IOException{
        SceneManager.loadAddWagonBasedOnScene();
    }
    @FXML
    private void goToWagonScene() throws IOException{
        SceneManager.loadWagonsScene();
    }

    public void openLog() throws IOException{
        File file = new File("C:\\Users\\sanne\\Documents\\GitHub\\antlr4-richrail-starter\\test.log");
        URI uri = file.toURI();
        if (Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)){
                desktop.browse(uri);
            }
        }
    }

}
