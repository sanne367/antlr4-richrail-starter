package richrail.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("wind")
public class WindPowerSource extends PowerSource{
    @Override
    public String toString() {
        return "[Powersource] " + this.getClass().getAnnotation(DiscriminatorValue.class).value()
                + " [Supported Weight] " + super.getMaxWeight();
    }
}
