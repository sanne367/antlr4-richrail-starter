package richrail.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("person")
public class PersonWagon extends Wagon {
    @Column
    private String optionalValue;

    private int numberOfPassengers;


    public PersonWagon(){};

    public PersonWagon(String optionalValue, int weight, String typeName){
        super(weight, typeName);
        this.optionalValue = optionalValue;
        this.numberOfPassengers = Integer.valueOf(optionalValue);
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    // TODO: 5-1-2021 equals uitwerken subclass
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof PersonWagon) {
            PersonWagon otherWagon = (PersonWagon) otherObject;
            return super.getId().equals(((PersonWagon) otherObject).getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value()+ " [NumberOfPassengers] " + this.numberOfPassengers + " " + super.toString();
    }
}
