package richrail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import richrail.application.AdministrationService;
import richrail.application.TrainService;
import richrail.data.InMemoryTrainDao;
import richrail.data.SpringTrainDao;
import richrail.data.TrainJpaRepository;
import richrail.domain.TrainDao;
import richrail.presentation.gui.TrainScene;
import richrail.presentation.gui.WelcomeScene;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class AppConfig {
    @Bean
    public WelcomeScene welcomeScene() {
        return new WelcomeScene();
    }

    @Bean
    public TrainScene trainSceneView(AdministrationService service) {
        return new TrainScene(service);
    }

    @Bean
    public AdministrationService administrationServiceV(TrainService trainService){
        return new AdministrationService(trainService);
    }
    @Bean
    public TrainService trainServiceV(SpringTrainDao trainDao) {
        return new TrainService(trainDao);
    }

    @Bean
    public TrainDao trainDaoV() {
        return new InMemoryTrainDao();
    }

    @Bean
    public SpringTrainDao springTrainDaoV(TrainJpaRepository trainJpaRepository){return new SpringTrainDao(trainJpaRepository);}
}
