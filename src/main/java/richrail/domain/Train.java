package richrail.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Train")
public class Train implements Iterable<TrainWagon> {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private int weight;

    @OneToOne(cascade = CascadeType.MERGE)
    private PowerSource powerSource;


    @OneToMany(mappedBy = "train" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<TrainWagon> train_wagons = new ArrayList<>();

    public Train(){};
    public Train(String name){
        this.name = name;
    }
    public Train(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Train(String name, List<TrainWagon> train_wagons) {
        this.name = name;
        this.train_wagons = train_wagons;
    }

    public void add(TrainWagon wagon) {
        if(train_wagons.contains(wagon)){
            int index = train_wagons.indexOf(wagon);
            train_wagons.get(index).setQuantity(train_wagons.get(index).getQuantity()+1);
        }
        this.train_wagons.add(wagon);
    }

    public void remove(TrainWagon wagon){
        if(train_wagons.contains(wagon)){
            int index = train_wagons.indexOf(wagon);
            if(train_wagons.get(index).getQuantity() >2){
                train_wagons.get(index).setQuantity(train_wagons.get(index).getQuantity() -1);
            }
            this.train_wagons.remove(wagon);
        }
    }

    public int calculateWeight(){
        //weight train + weight wagons <= maxWeight powersource
        return 0;
    }

    public void remove(int index) {
        this.train_wagons.remove(index);
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<TrainWagon> iterator() {
        return this.train_wagons.iterator();
    }

    public List<TrainWagon> getTrain_wagons() {
        return train_wagons;
    }


    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(name, train.name) && Objects.equals(weight, train.weight);
    }

    public String toString(){
        return "Train: " + this.name + " " + this.powerSource + " " + this.train_wagons;
    }


}
