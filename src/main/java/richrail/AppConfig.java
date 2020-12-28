package richrail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import richrail.application.AdministrationService;
import richrail.application.TrainService;
import richrail.application.WagonService;
import richrail.data.*;
import richrail.domain.TrainDao;
import richrail.domain.WagonDao;
import richrail.presentation.gui.TrainInfoScene;
import richrail.presentation.gui.TrainScene;
import richrail.presentation.gui.WagonsScene;
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
    public AdministrationService administrationServiceV(TrainService trainService, WagonService wagonService){
        return new AdministrationService(trainService, wagonService);
    }
    @Bean
    public TrainService trainServiceV(SpringTrainDao trainDao) {
        return new TrainService(trainDao);
    }

    @Bean
    public WagonService wagonServiceV(SpringWagonDao wagonDao){
        return new WagonService(wagonDao);
    }

    @Bean
    public SpringWagonDao springWagonDaoV(WagonJpaRepository wagonJpaRepository){
        return new SpringWagonDao(wagonJpaRepository);
    }
    @Bean
    public TrainDao trainDaoV() {
        return new InMemoryTrainDao();
    }

    @Bean
    public TrainInfoScene trainInfoSceneV(AdministrationService service){
        return new TrainInfoScene(service);
    }

    @Bean
    public WagonsScene wagonsSceneV(AdministrationService service){return new WagonsScene(service);}

    @Bean
    public SpringTrainDao springTrainDaoV(TrainJpaRepository trainJpaRepository){return new SpringTrainDao(trainJpaRepository);}
}
