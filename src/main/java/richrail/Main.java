package richrail;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main  {

    public static void main(String[] args) {
        Application.launch(TrainApplication.class, args);


    }
}