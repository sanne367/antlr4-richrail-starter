package richrail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import richrail.application.AdministrationService;
import richrail.application.PowerSourceService;
import richrail.application.TrainService;
import richrail.application.WagonService;
import richrail.data.*;
import richrail.domain.TrainDao;
import richrail.presentation.gui.*;

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
    public AdministrationService administrationServiceV(TrainService trainService, WagonService wagonService, PowerSourceService powerSourceService){
        return new AdministrationService(trainService, wagonService, powerSourceService);
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
    public PowerSourceService powerSourceServiceV(SpringPowerSourceDao springPowerSourceDao){
        return new PowerSourceService(springPowerSourceDao);
    }

    @Bean
    public SpringPowerSourceDao springPowerSourceDao(PowerSourceJpaRepository powerSourceJpaRepository){
        return new SpringPowerSourceDao(powerSourceJpaRepository);
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
    public AddWagonToTrainScene wagonsSceneV(AdministrationService service){return new AddWagonToTrainScene(service);}

    @Bean
    public AddWagonBasedOnScene addWagonBasedOnSceneV(AdministrationService service){
        return new AddWagonBasedOnScene(service);
    }
    @Bean
    public AddTrainScene addTrainSceneV(AdministrationService service){
        return new AddTrainScene(service);
    }
    @Bean
    public DeleteTrainScene deleteTrainSceneV(AdministrationService service){
        return new DeleteTrainScene(service);
    }
    @Bean
    public SpringTrainDao springTrainDaoV(TrainJpaRepository trainJpaRepository){return new SpringTrainDao(trainJpaRepository);}
}
