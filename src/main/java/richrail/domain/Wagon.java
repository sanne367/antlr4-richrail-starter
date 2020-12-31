package richrail.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "wagon_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    private String wagonTypeName;

    @Column
    private int weight;


    public Wagon(){}

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWagonTypeName() {
        return wagonTypeName;
    }

    public void setWagonTypeName(String wagonType) {
        this.wagonTypeName = wagonType;
    }


    //    @Override
//    public String toString() {
//        return "Wagon:" + this.getClass().getAnnotation(DiscriminatorColumn.class).name();
//    }
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Wagon) {
            Wagon otherWagon = (Wagon) otherObject;

            if (
                    getWagonTypeName().equals(otherWagon.getWagonTypeName()) &&
                    getWeight() == ((Wagon) otherObject).getWeight())
                return true;
        }
        return false;
    }
}
