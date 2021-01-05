package richrail.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("car")
public class CarWagon extends Wagon{
    @Column
    private String optionalValue;

    private String nameOfCar;

    public CarWagon(){};

    public CarWagon(String nameOfCar, int weight, String typeName){
        super(weight, typeName);
        this.optionalValue = nameOfCar;
        this.nameOfCar = nameOfCar;
    }

    public String getNameOfCar() {
        return nameOfCar;
    }
    public void setNameOfGoods(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    // TODO: 5-1-2021 equals uitwerken subclass
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof CarWagon) {
            CarWagon otherWagon = (CarWagon) otherObject;
            return super.getId().equals(((CarWagon) otherObject).getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value()+ " [NameOfCar] " + this.nameOfCar + " " + super.toString();
    }
}
