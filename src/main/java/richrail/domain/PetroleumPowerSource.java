package richrail.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("petroleum")
public class PetroleumPowerSource extends PowerSource {

    // TODO: 5-1-2021 hoezo kunnen de powersources constructor private zijn
    public PetroleumPowerSource(){
        super(10000, "high");
    }

    @Override
    public String toString() {
        return "[Powersource] " + this.getClass().getAnnotation(DiscriminatorValue.class).value()
                + super.toString();
    }

}
