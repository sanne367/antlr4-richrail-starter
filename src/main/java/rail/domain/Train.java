package rail.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "train", schema = "public")
public class Train implements Buildable{
    @Id
    @SequenceGenerator(name = "train_SEQ", sequenceName = "SEQUENCE_train", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "train_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(cascade = { CascadeType.MERGE})
////    @JoinTable(
////            name = "traincomponent",
////            joinColumns = {@JoinColumn(name = "train_id",referencedColumnName = "id")},
////            inverseJoinColumns = {@JoinColumn(name = "component_id",referencedColumnName = "id")}
////
////    )
    @OneToMany(mappedBy = "train")
    private List<TrainComponent> trainComponents;
    public Train(String name){
        this.name = name;
    }

    public Train(){};

    public Train(String name, List<TrainComponent> allTrainComponents){
        this.name = name;
        this.trainComponents = allTrainComponents;
    }

    @Override
    public String toString() {
        String s =  "Train: " + name + " has id: " + id + " " +
                " has components : ";
        for(TrainComponent t : getTrainComponents()){
            s += t.toString();
        }
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrainComponent> getTrainComponents() {
        return trainComponents;
    }

    public void setTrainComponents(List<TrainComponent> trainComponents) {
        this.trainComponents = trainComponents;
    }

    public static TrainBuilder builder() {
        return new TrainBuilder();
    }

    public static class TrainBuilder implements IBuilder{
        private String name;
//        private List<TrainComponent> allTrainComponents;
//
//        public void setAllTrainComponents(List<TrainComponent> allTrainComponents) {
//            this.allTrainComponents = allTrainComponents;
//        }

        TrainBuilder(){}

        public TrainBuilder name(String name){
            this.name = name;
            return this;
        }

        public Train build(){
            return new Train(name);
        }
    }
}
