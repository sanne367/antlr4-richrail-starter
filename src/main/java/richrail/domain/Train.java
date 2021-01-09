package richrail.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import richrail.domain.exception.WeightNotAllowed;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Train")
public class Train implements Iterable<TrainWagon>, Cloneable {
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

    @OneToMany(orphanRemoval=true,mappedBy = "train" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<TrainWagon> trainWagons = new ArrayList<>();

    public Train(){};

    public Train(String name){
        this.name = name;
    }

    public Train(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Train(String name, List<TrainWagon> trainWagons) {
        this.name = name;
        this.trainWagons = trainWagons;
    }

    public void setTrainWagons(List<TrainWagon> trainWagons) {
        this.trainWagons = trainWagons;
    }

    public void addNew(TrainWagon wagon) {
        System.out.println(checkWeightAllowed(wagon.getWagon()));
        if(!checkWeightAllowed(wagon.getWagon())) {
            throw new WeightNotAllowed("Not allowed, weight extended");
        }
        wagon.setQuantity(1);
        this.trainWagons.add(wagon);
    }

    //next project: different approach quantity
    public void addQuantity(Wagon wagon){
        System.out.println(checkWeightAllowed(wagon));
        if(!checkWeightAllowed(wagon)) {
            throw new WeightNotAllowed("Not allowed, weight extended");
        }
        for (TrainWagon trainWagon : trainWagons) {
            if (trainWagon.getWagon().equals(wagon)) {
                trainWagon.setQuantity(trainWagon.getQuantity() + 1);
            }
        }
    }

    public void removeWagon(TrainWagon wagon) {
        Iterator<TrainWagon> wagons = trainWagons.iterator();
        while (wagons.hasNext()) {
            TrainWagon trainWagon = wagons.next();
            if (trainWagon.getWagon().equals(wagon.getWagon())) {
                if(trainWagon.getQuantity() == 1){
                    trainWagon.setQuantity(0);
                }
                else {
                    trainWagon.setQuantity(trainWagon.getQuantity() -1);
                }
                //wagons.remove();
            }
        }
    }

    private boolean checkWeightAllowed(Wagon wagon) {
        System.out.println(this.powerSource.getMaxWeight());
        System.out.println(calculateWeight() + wagon.getWeight());
        return calculateWeight() + wagon.getWeight() <= this.powerSource.getMaxWeight();
    }

    public int calculateWeight(){
        int weightTotal = this.weight;
        for(TrainWagon wagon : trainWagons){
           int wagonWeight =  wagon.getWagon().getWeight();
           int quantity = wagon.getQuantity();
           weightTotal += wagonWeight * quantity;
        }
        return weightTotal;
    }

    public boolean checkExistenceTrainWagon(Wagon wagon){
        for(TrainWagon trainWagon : this.trainWagons)
            if (trainWagon.getWagon().equals(wagon)) return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public Iterator<TrainWagon> iterator() {
        return this.trainWagons.iterator();
    }

    public List<TrainWagon> getTrainWagons() {
        return trainWagons;
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

    public String toString(){
        return "[Train]: " + this.name + "[id] " + this.id + " " + this.powerSource + " " + this.trainWagons;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Train) {
            Train otherTrain = (Train) otherObject;
            return this.id.equals(otherTrain.id);
        }
        return false;
    }

}
