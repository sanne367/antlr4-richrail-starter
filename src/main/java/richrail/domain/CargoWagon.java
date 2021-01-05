package richrail.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cargo")
public class CargoWagon extends Wagon {
    @Column
    private String optionalValue;

    private String nameOfGoods;

    public CargoWagon(){};

    public CargoWagon(String nameOfGoods, int weight, String typeName){
        super(weight, typeName);
        this.optionalValue = nameOfGoods;
        this.nameOfGoods = nameOfGoods;
    }

    public String getNameOfGoods() {

        return nameOfGoods;
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }

    @Override
    public String toString() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value()+ " [NameOfGoods] " + nameOfGoods + " " + super.toString();
    }

    // TODO: 5-1-2021 equals uitwerken subclass
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof CargoWagon) {
            CargoWagon otherWagon = (CargoWagon) otherObject;
            super.getId().equals(((CargoWagon) otherObject).getId());
        }
        return false;
    }
}
