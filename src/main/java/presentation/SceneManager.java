//bron: javafx-spring-context-example, A.Rothuis HU

package presentation;

import application.domain.Train;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URL;

public class SceneManager {
    private static final String welcome_scene = "welcome";
    private static final String trainList_scene = "trainviewlist";
    private static final String trainview_scene = "trainview";

    private static ApplicationContext context;
    private static Scene scene;

    public static void start(ApplicationContext ctx, Stage stage) throws IOException {
        // Setup Spring Context for dependency injection
        context = ctx;

        // Start on the welcome scene
        scene = new Scene(loadFXML(welcome_scene));
        stage.setScene(scene);

        // Set values for window (stage) and show it
        stage.setTitle("Notes");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.show();
    }

    public static void showTrainList() throws IOException {
        scene.setRoot(loadFXML(trainList_scene));
    }

    public static void showTrainInfo()throws IOException{
        scene.setRoot(loadFXML(trainview_scene));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // Find the FXML in the resources directory matching the location of this class
        URL resource = SceneManager.class.getResource(fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        // Use the Spring dependency injection container for Beans
        fxmlLoader.setControllerFactory(context::getBean);

        return fxmlLoader.load();
    }
}
