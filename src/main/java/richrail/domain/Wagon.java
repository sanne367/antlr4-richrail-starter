package richrail.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "wagon_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String wagonTypeName;

    @OneToMany(orphanRemoval=true,mappedBy = "wagon" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TrainWagon> train_wagons = new ArrayList<>();

    @Column
    private int weight;

    public Wagon(){
        this.weight = 0;
        this.wagonTypeName = "Generic";
    }

    public Wagon(int weight, String wagonTypeName){
        this.weight = weight;
        this.wagonTypeName = wagonTypeName;
    }

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

    @Override
    public String toString() {
        return "[Weight]:" + this.weight + " [WagonTypeName]:" + this.wagonTypeName;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Wagon) {
            Wagon otherWagon = (Wagon) otherObject;
            return getWagonTypeName().equals(otherWagon.getWagonTypeName()) &&
                    getWeight() == ((Wagon) otherObject).getWeight();
        }
        return false;
    }
}
