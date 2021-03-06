package richrail.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("electric")
public class ElectricPowerSource extends PowerSource{

    public ElectricPowerSource(){
        super(4000, "medium");
    }

    @Override
    public String toString() {
        return "[Powersource] " + this.getClass().getAnnotation(DiscriminatorValue.class).value()
                + super.toString();
    }
}
