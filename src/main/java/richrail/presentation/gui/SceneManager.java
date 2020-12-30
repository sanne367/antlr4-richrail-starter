//bron: javafx-spring-context-example, A.Rothuis HU

package richrail.presentation.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import richrail.application.AdministrationService;
import richrail.application.TrainService;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

// implement singleton?

public class SceneManager {
    private static final String WELCOME_SCENE = "welcome";
    private static final String TRAINS_SCENE = "allTrains";
    private static final String TRAIN_SCENE = "trainview";
    private static final String WAGONADDTRAIN_SCENE = "addwagontotrain";
    private static final String ADDTRAIN_SCENE = "addTrain";
    private static final String DELETETRAIN_SCENE = "deleteTrain";

    private static ApplicationContext context;
    private static Scene scene;

    public static void start(ApplicationContext ctx, Stage stage) throws IOException {
        // Setup Spring Context for dependency injection
        context = ctx;

        // Start on the welcome scene
        scene = new Scene(loadFXML(WELCOME_SCENE));
        stage.setScene(scene);

        // Set values for window (stage) and show it
        stage.setTitle("RichRail");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // Find the FXML in the resources directory matching the location of this class
        URL resource = SceneManager.class.getResource(fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        // Use the Spring dependency injection container for Beans
        fxmlLoader.setControllerFactory(context::getBean);

        return fxmlLoader.load();
    }

    public static void loadTrainScene() throws IOException {
        scene.setRoot(loadFXML(TRAINS_SCENE));
    }

    public static void loadTrainInfoScene() throws IOException {
        scene.setRoot(loadFXML(TRAIN_SCENE));
    }

    public static void loadWagonTrainScene() throws IOException{
        scene.setRoot(loadFXML(WAGONADDTRAIN_SCENE));
    }
    // TODO: 27-12-2020 log bijhouden & export

    public static void loadAddTrainScene() throws IOException{
        scene.setRoot(loadFXML(ADDTRAIN_SCENE));
    }
    public static void loadDeleteTrainScene() throws IOException{
        scene.setRoot(loadFXML(DELETETRAIN_SCENE));
    }
}
