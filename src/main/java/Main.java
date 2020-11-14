import application.domain.Component;

import application.domain.ComponentType;
import businesslogic.parser.controllers.TrainAdministratorController;
import businesslogic.parser.parser.RichRailCli;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import persistence.postgresDaoImpl.TrainComponentPostgresDaoImpl;

import java.util.List;


public class Main {
    public static void main(String[] args) {
//        CharStream lineStream = CharStreams.fromString("new train tr1");
//
//        // Tokenize / Lexical analysis
//        Lexer lexer = new RichRailLexer(lineStream);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        // Create Parse Tree
//        RichRailParser parser = new RichRailParser(tokens);
//        ParseTree tree = parser.command();
//
//        // Create ParseTreeWalker and Custom Listener
//        ParseTreeWalker walker = new ParseTreeWalker();
//        RichRailListener listener = new RichRailCli();
//
//        // Walk over ParseTree using Custom Listener that listens to enter/exit events
//        walker.walk(listener, tree);

        TrainAdministratorController trainAdministratorController = new TrainAdministratorController();
//        ComponentType componentType = new ComponentType("Persoon");
//        trainAdministratorController.saveComponentType(componentType);
        System.out.println(trainAdministratorController.giveAllComponentTypes());
        ComponentType savedType = trainAdministratorController.allComponentTypesByName("Persoon").get(0);
        System.out.println(trainAdministratorController.giveAllTrains());
        ComponentType componentType2 = trainAdministratorController.getComponenttypeById(1);
        System.out.println(componentType2);
        //Component component = new Component(componentType2, "Kind_onder11_jaar");
        //trainAdministratorController.saveComponent(component);
        List<Component> all = trainAdministratorController.giveComponentByTypeId(componentType2);
        System.out.println(all);
        Component component2 = trainAdministratorController.giveComponentByName("Kind_onder11_jaar").get(0);
        System.out.println(component2);
        trainAdministratorController.setTrainName("test1");
        trainAdministratorController.saveTrain(trainAdministratorController.buildTrain());
        trainAdministratorController.setTrainComponentToTrain(component2, 1);
        System.out.println(trainAdministratorController.giveAllTrains());
        System.out.println(trainAdministratorController.allTrainComponents());


    }
}
