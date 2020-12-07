package rail.presentation;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends Application {

    public void start(Stage stage) throws IOException {
        // Setup Spring Context for dependency injection (DI)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Configure and wire up Beans in AppConfig
        context.register(AppConfig.class);
        context.refresh();

        // Configure and boot up gui through SceneManager
        SceneManager.start(context, stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

//    public static void main(String[] args) {
////        CharStream lineStream = CharStreams.fromString("new train tr1");
////
////        // Tokenize / Lexical analysis
////        Lexer lexer = new RichRailLexer(lineStream);
////        CommonTokenStream tokens = new CommonTokenStream(lexer);
////
////        // Create Parse Tree
////        RichRailParser parser = new RichRailParser(tokens);
////        ParseTree tree = parser.command();
////
////        // Create ParseTreeWalker and Custom Listener
////        ParseTreeWalker walker = new ParseTreeWalker();
////        RichRailListener listener = new RichRailCli();
////
////        // Walk over ParseTree using Custom Listener that listens to enter/exit events
////        walker.walk(listener, tree);
//
//        TrainAdministratorController trainAdministratorController = new TrainAdministratorController();
////        ComponentType componentType = new ComponentType("Persoon");
////        trainAdministratorController.saveComponentType(componentType);
//        System.out.println(trainAdministratorController.giveAllComponentTypes());
//        ComponentType savedType = trainAdministratorController.allComponentTypesByName("Persoon").get(0);
//        System.out.println(trainAdministratorController.giveAllTrains());
//        ComponentType componentType2 = trainAdministratorController.getComponenttypeById(1);
//        System.out.println(componentType2);
//        //Wagon component = new Wagon(componentType2, "Kind_onder11_jaar");
//        //trainAdministratorController.saveComponent(component);
//        List<Wagon> all = trainAdministratorController.giveComponentByTypeId(componentType2);
//        System.out.println(all);
//        Wagon component2 = trainAdministratorController.giveComponentByName("Kind_onder11_jaar").get(0);
//        System.out.println(component2);
//        trainAdministratorController.setTrainName("test1");
//        trainAdministratorController.saveTrain(trainAdministratorController.buildTrain());
//        trainAdministratorController.setTrainComponentToTrain(component2, 1);
//        System.out.println(trainAdministratorController.giveAllTrains());
//        System.out.println(trainAdministratorController.allTrainComponents());

}