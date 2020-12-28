package richrail.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@DiscriminatorValue("cargo")
public class CargoWagon extends Wagon {

    @Column
    private String nameOfGoods;

    @Override
    public String toString() {
        return "Wagon:" + this.getClass().getAnnotation(DiscriminatorValue.class).value() +
                "wagon_type_name : " + super.getWagonType() + "name of goods: " + nameOfGoods +
        " weight: " + getWeight();

    }

    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public void setWeight(int weight){
        super.setWeight(weight);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }
}
