package richrail.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("electric")
public class ElectricPowerSource extends PowerSource{

}
