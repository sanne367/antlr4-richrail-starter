package richrail;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import richrail.presentation.gui.SceneManager;

import java.io.IOException;

public class TrainApplication extends Application {
    public void start(Stage stage) throws IOException {
        // Setup Spring Context for dependency injection (DI)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Configure and wire up Beans in AppConfig
        context.register(AppConfig.class);
        context.refresh();

        // Configure and boot up gui through SceneManager
        SceneManager.start(context, stage);
    }
}
