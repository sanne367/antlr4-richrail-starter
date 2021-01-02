package richrail.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @OneToMany(orphanRemoval=true,mappedBy = "train" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public void setTrain_wagons(List<TrainWagon> train_wagons) {
        this.train_wagons = train_wagons;
    }

    // TODO: 1-1-2021 single responsibility principe wat betreft wagons/train,wagons
    public boolean addNew(TrainWagon wagon) {
        System.out.println(checkWeightAllowed(wagon.getWagon()));
        if(checkWeightAllowed(wagon.getWagon())){
            wagon.setQuantity(1);
            this.train_wagons.add(wagon);
            return true;
        }
        return false;
    }

    public boolean addQuantity(Wagon wagon){
        System.out.println(checkWeightAllowed(wagon));
        if(checkWeightAllowed(wagon)){
            for (TrainWagon trainWagon : train_wagons) {
                if (trainWagon.getWagon().equals(wagon)) {
                    trainWagon.setQuantity(trainWagon.getQuantity() + 1);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeWagon(TrainWagon wagon) {
        // TODO: 1-1-2021 iterator gebruiken
        Iterator<TrainWagon> wagons = train_wagons.iterator();
        while (wagons.hasNext()) {
            TrainWagon trainWagon = wagons.next();
            if (trainWagon.getWagon().equals(wagon.getWagon())) {
                if (trainWagon.getQuantity() == 1) {
                    wagons.remove();
                    return true;
                }
                if (trainWagon.getQuantity() >= 2) {
                    trainWagon.setQuantity(trainWagon.getQuantity() - 1);
                    return true;
                }
            }
        }
        return false;
    }



//
//        System.out.println("wagon to delete" + wagon.getWagon().getId() + wagon.getTrain().id);
//        TrainWagon wagonToDelete = null;
//        for(TrainWagon trainWagon : this.train_wagons) {
//            //int index = train_wagons.indexOf(trainWagon);
//            System.out.println("wagon list" + trainWagon.getWagon().getId() + trainWagon.getTrain().id);
//            if (trainWagon.getWagon().equals(wagon.getWagon())) {
//                System.out.println("equals werkt");
//                if (trainWagon.getQuantity() >= 2) {
//                    System.out.println(trainWagon.getQuantity());
//                    trainWagon.setQuantity(trainWagon.getQuantity() - 1);
//                    return true;
//                } else if (trainWagon.getQuantity() == 1) {
//
//                    System.out.println("heoejoeje");
//                    wagonToDelete = trainWagon;
//                }
//            }
//        }
//        for(TrainWagon trainWagon : train_wagons){
//            System.out.println(trainWagon.equals(wagonToDelete));
//        }
//        return train_wagons.remove(wagonToDelete);
//        //return false;
//
//    }

//        public boolean re
////        return train_wagons.remove(wagonToRemove);
////    }moveFromList(){
//
//    public boolean removeFromList(TrainWagon wagon){
//        for(Iterator<TrainWagon> iterator = train_wagons.iterator(); iterator.hasNext();){
//            TrainWagon element = iterator.next();
//            if(element.equals(wagon)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean checkWeightAllowed(Wagon wagon){
        System.out.println(this.powerSource.getMaxWeight());
        System.out.println(calculateWeight() + wagon.getWeight());
        return calculateWeight() + wagon.getWeight() <= this.powerSource.getMaxWeight();
    }

    public int calculateWeight(){
        int weightTrain = this.weight;
        int weightTotal = 0;
        for(TrainWagon wagon : train_wagons){
           int wagonWeight =  wagon.getWagon().getWeight();
           int quantity = wagon.getQuantity();
           int totalWagon = wagonWeight * quantity;
           weightTotal += totalWagon;
        }
        weightTotal += weightTrain;
        return weightTotal;
    }

    public boolean checkExistenceTrainWagon(Wagon wagon){
        for(TrainWagon trainWagon : this.train_wagons){
            if(trainWagon.getWagon().equals(wagon)){
                return true;
            }
        }
        return false;
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


    public String toString(){
        return "[Train]: " + this.name + "[id] " + this.id + " " + this.powerSource + " " + this.train_wagons;
    }


    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof Train) {
            Train otherTrain = (Train) otherObject;

            if (this.id.equals(otherTrain.id))
                return true;
        }
        return false;
    }

}
