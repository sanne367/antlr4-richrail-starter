import application.domain.Component;
import application.domain.ComponentType;
import application.domain.Train;
import businesslogic.parser.controllers.TrainAdministratorController;
import businesslogic.parser.parser.RichRailCli;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


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
//        System.out.println(trainAdministratorController.giveAllComponentTypes());
//        ComponentType savedType = trainAdministratorController.allComponentTypesByName(componentType.getTypeName()).get(0);
//        System.out.println(savedType);
        ComponentType componentType = trainAdministratorController.getComponenttypeById(1);
        Component component = new Component(componentType, "Kind <11 jaar");
        trainAdministratorController.saveComponent(component);
        ComponentType componentType1 = trainAdministratorController.giveAllComponentTypes().get(0);
        Component savedComponent = trainAdministratorController.giveComponentByTypeId(componentType1);
        System.out.println(savedComponent);
//        trainAdministratorController.setTrainName("test1");
//        trainAdministratorController.saveTrain(trainAdministratorController.buildTrain());
        // TODO: 12-11-2020 querys name werkend


//       trainAdministratorController.setTrainComponentToTrain(savedComponent, 1);

       System.out.println(trainAdministratorController.giveAllTrains());
//        System.out.println(train);

    }
}
