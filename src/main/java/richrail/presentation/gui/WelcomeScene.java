package richrail.presentation.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

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




//    @FXML
//    private void goToTrainInfoScene() throws IOException {
//        SceneManager.loadTrainInfoScene();
//    }
}
