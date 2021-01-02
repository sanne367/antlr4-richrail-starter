package richrail.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "wagon_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   // @OnDelete(action = OnDeleteAction.CASCADE)
//    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    private String wagonTypeName;

    @OneToMany(orphanRemoval=true,mappedBy = "wagon" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TrainWagon> train_wagons = new ArrayList<>();

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

    // TODO: 2-1-2021 equals/lijst
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
