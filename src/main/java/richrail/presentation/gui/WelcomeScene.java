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



//    @FXML
//    private void goToTrainInfoScene() throws IOException {
//        SceneManager.loadTrainInfoScene();
//    }
}
