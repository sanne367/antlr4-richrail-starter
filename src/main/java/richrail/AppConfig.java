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

//    @Bean
//    public TrainScene trainSceneView(AdministrationService service) {
//        return new TrainScene(service);
//    }
    @Bean
    public GuiPowerSourceService guiPowerSourceServiceV(AdministrationService service) {
        return new GuiPowerSourceService(service);
    }
    @Bean
    public GuiWagonService guiWagonServiceV(AdministrationService service) {
    return new GuiWagonService(service);
}
    @Bean
    public GuiTrainService guiTrainServiceV(AdministrationService service) {
        return new GuiTrainService(service);
    }
    @Bean
    public TrainScene trainSceneView(GuiTrainService service, AdministrationService service2) {
        return new TrainScene(service, service2);
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

//    @Bean
//    public TrainInfoScene trainInfoSceneV(AdministrationService service){
//
//        return new TrainInfoScene(service);
//    }
    @Bean
    public TrainInfoScene trainInfoSceneV(GuiTrainService service, GuiWagonService wagonService){

        return new TrainInfoScene(service, wagonService);
    }

    @Bean
    public AddWagonToTrainScene wagonsSceneV(GuiWagonService service, GuiTrainService service1){return new AddWagonToTrainScene(service1, service);}

    @Bean
    public AddWagonBasedOnScene addWagonBasedOnSceneV(GuiWagonService service){
        return new AddWagonBasedOnScene(service);
    }
    @Bean
    public DeleteWagonScene deleteWagonSceneV(GuiWagonService service){
        return new DeleteWagonScene(service);
    }

    @Bean
    public WagonScene wagonScene(GuiWagonService service){
        return new WagonScene(service);
    }
    @Bean
    public ShowTrainPictureScene showTrainPictureSceneV(GuiWagonService service, GuiTrainService service1){
        return new ShowTrainPictureScene(service1, service);
    }
    @Bean
    public AddTrainScene addTrainSceneV(GuiTrainService service, GuiPowerSourceService sourceService){
        return new AddTrainScene(service, sourceService);
    }
    @Bean
    public DeleteTrainScene deleteTrainSceneV(GuiTrainService service){
        return new DeleteTrainScene(service);
    }
    @Bean
    public SpringTrainDao springTrainDaoV(TrainJpaRepository trainJpaRepository){return new SpringTrainDao(trainJpaRepository);}
}
