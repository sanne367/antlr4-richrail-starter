package richrail.presentation.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;

public class ImageViewBase {
    //private String filePath = "/antlr4-richrail-starter/src/main/resources/richrail/presentation/gui/";
    private String filePath = "C:/Users/sanne/Documents/GitHub/antlr4-richrail-starter/src/main/resources/richrail/presentation/gui/";

    public ImageViewBase(){};

    public ImageView createImage(String imgPath) throws IOException {
        FileInputStream inputstream = new FileInputStream(filePath + imgPath);
        Image image = new Image(inputstream);
        return new javafx.scene.image.ImageView(image);
    }

}
