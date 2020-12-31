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
        if(this.nameOfGoods == null|| this.getWeight() == 0 || this.getWagonTypeName() == null){
           return this.getClass().getAnnotation(DiscriminatorValue.class).value() + " Wagon" ;
        }else{
            return " [Wagon] " + this.getClass().getAnnotation(DiscriminatorValue.class).value()+
                    " [Wagon_type_name] " + super.getWagonTypeName() + " [Name of goods] " + nameOfGoods +
                    " [Weight] " + getWeight();
        }
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

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof CargoWagon) {
            CargoWagon otherWagon = (CargoWagon) otherObject;

            if (this.nameOfGoods.equals(otherWagon.nameOfGoods) &&
                    super.getWagonTypeName().equals(otherWagon.getWagonTypeName()) &&
                    super.getWeight() == ((CargoWagon) otherObject).getWeight())
                return true;
            }
        return false;
    }
}
