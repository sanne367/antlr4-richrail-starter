package richrail.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("wind")
public class WindPowerSource extends PowerSource{
    // TODO: 5-1-2021 hoezo kunnen de powersources constructor private zijn
    public WindPowerSource(){
        super(300, "low");
    }

    @Override
    public String toString() {
        return "[Powersource] " + this.getClass().getAnnotation(DiscriminatorValue.class).value()
                + super.toString();
    }
}
