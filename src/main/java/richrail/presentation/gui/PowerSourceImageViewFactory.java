package richrail.presentation.gui;

import richrail.domain.CarWagon;
import richrail.domain.CargoWagon;
import richrail.domain.PetroleumPowerSource;
import richrail.domain.WindPowerSource;

import java.io.IOException;

public class PowerSourceImageViewFactory implements ImageViewFactory{
    private Class<?> powerBasedClass;
    private ImageViewBase imageViewBase;
    private String windPowersourceTrain = "wind2.PNG";
    private String electricPowersourceTrain = "electric.PNG";
    private String petroleumPowersourceTrain = "petroleum2.PNG";

    public PowerSourceImageViewFactory(Class<?> powerBasedClass){

        this.powerBasedClass = powerBasedClass;
        this.imageViewBase = new ImageViewBase();
    }

    @Override
    public javafx.scene.image.ImageView createImageview() throws IOException {
        if(powerBasedClass == PetroleumPowerSource.class){
            return imageViewBase.createImage(petroleumPowersourceTrain);
        }else if(powerBasedClass == WindPowerSource.class){
            return imageViewBase.createImage(windPowersourceTrain);
        }else {
            return imageViewBase.createImage(electricPowersourceTrain);
        }
    }

}
