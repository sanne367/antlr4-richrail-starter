package richrail.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@DiscriminatorValue("cargo")
public class CargoWagon extends Wagon {

    @Override
    public String toString() {
        return "Wagon:" + this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }
}
