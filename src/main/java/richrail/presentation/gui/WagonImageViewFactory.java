package richrail.presentation.gui;

import javafx.scene.image.Image;
import richrail.domain.CarWagon;
import richrail.domain.CargoWagon;
import richrail.domain.Wagon;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class WagonImageViewFactory implements ImageViewFactory{
    private Class<?> wagonBasedClass;
    private ImageViewBase imageViewBase;

    private String cargoWagon = "cargo.PNG";
    private String personWagon = "person.PNG";
    private String carWagon = "car.PNG";

    public WagonImageViewFactory(Class<?> wagonBasedClass){
        this.wagonBasedClass = wagonBasedClass;
        this.imageViewBase = new ImageViewBase();
    }

    @Override
    public javafx.scene.image.ImageView createImageview() throws IOException {
        System.out.println(wagonBasedClass);
        if(wagonBasedClass == CarWagon.class){
            return imageViewBase.createImage(carWagon);
        }else if(wagonBasedClass == CargoWagon.class){
            return imageViewBase.createImage(cargoWagon);
        }else {
            return imageViewBase.createImage(personWagon);
        }
    }


}
