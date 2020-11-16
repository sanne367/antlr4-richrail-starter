package presentation;

import application.domain.Train;
import businesslogic.parser.controllers.TrainAdministratorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public TrainAdministratorController trainAdministratorController(){
        return new TrainAdministratorController();
    };

    @Bean
    public Train train(){
        return new Train();
    };

    @Bean
    public WelcomeScene welcome(){return new WelcomeScene();}

    @Bean
    public TrainListScene trainList(TrainAdministratorController trainAdministratorController){
        return new TrainListScene(trainAdministratorController);
    }

    @Bean
    public TrainScene trainInfo(TrainAdministratorController trainAdministratorController){
        return new TrainScene(trainAdministratorController);
    }

}
