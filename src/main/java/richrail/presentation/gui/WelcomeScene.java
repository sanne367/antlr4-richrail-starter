package richrail.presentation.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class WelcomeScene {
    @FXML
    private void goToTrainScene() throws IOException {
        SceneManager.loadTrainScene();
    }

//    @FXML
//    private void goToTrainInfoScene() throws IOException {
//        SceneManager.loadTrainInfoScene();
//    }
}
