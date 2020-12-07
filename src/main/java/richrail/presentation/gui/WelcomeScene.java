package richrail.presentation.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class WelcomeScene {
    @FXML
    private void goToTrainScene() throws IOException {
        SceneManager.loadTrainScene();
    }
}
