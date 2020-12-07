package richrail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import richrail.application.TrainService;
import richrail.data.InMemoryTrainDao;
import richrail.domain.TrainDao;
import richrail.presentation.gui.TrainScene;
import richrail.presentation.gui.WelcomeScene;

@Configuration
public class AppConfig {
    @Bean
    public WelcomeScene welcomeScene() {
        return new WelcomeScene();
    }

    @Bean
    public TrainScene trainScene(TrainService service) {
        return new TrainScene(service);
    }

    @Bean
    public TrainService trainService(TrainDao dao) {
        return new TrainService(dao);
    }

    @Bean
    public TrainDao trainDao() {
        return new InMemoryTrainDao();
    }
}
