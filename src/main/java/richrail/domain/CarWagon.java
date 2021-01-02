package richrail.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("car")
public class CarWagon extends Wagon{

    @Column
    private String nameOfGoods;
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
        if (otherObject instanceof CarWagon) {
            CarWagon otherWagon = (CarWagon) otherObject;

//            if (this.nameOfGoods.equals(otherWagon.nameOfGoods) &&
////                    super.getWagonTypeName().equals(otherWagon.getWagonTypeName()) &&
////                    super.getWeight() == ((CargoWagon) otherObject).getWeight())
////                return true;
////            }
            if (super.getId().equals(((CarWagon) otherObject).getId())) {
                return true;
            }

        }
        return false;
    }


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
}
