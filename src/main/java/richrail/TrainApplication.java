package richrail;

import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import richrail.presentation.gui.SceneManager;

import java.io.IOException;

public class TrainApplication extends Application {
    private static final Logger logger = LoggerFactory.getLogger(TrainApplication.class);

    public void start(Stage stage) throws IOException {
        logger.info("Example log {}", TrainApplication.class.getName());

        // Setup Spring Context for dependency injection (DI)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Configure and wire up Beans in AppConfig
        context.register(AppConfig.class);
        context.refresh();

        // Configure and boot up gui through SceneManager
        SceneManager.start(context, stage);
    }
}
