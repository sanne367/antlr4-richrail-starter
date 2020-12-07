package rail.presentation;

import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class WelcomeScene {

    @FXML
    private void goToTrainList() throws IOException{
        SceneManager.showTrainList();
    }

    @FXML
    private void goToTrainComponentAdd() throws IOException{
        SceneManager.showTrainComponentAdd();
    }

}
