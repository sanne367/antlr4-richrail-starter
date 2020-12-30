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

    public String getWagonType() {
        return wagonTypeName;
    }

    public void setWagonType(String wagonType) {
        this.wagonTypeName = wagonType;
    }


    //    @Override
//    public String toString() {
//        return "Wagon:" + this.getClass().getAnnotation(DiscriminatorColumn.class).name();
//    }
}
