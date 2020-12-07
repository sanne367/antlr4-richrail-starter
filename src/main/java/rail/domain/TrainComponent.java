package rail.domain;


import javax.persistence.*;

@Entity
@Table(name = "traincomponent", schema = "public")
public class TrainComponent {

    @Id
    @SequenceGenerator(name = "traincomponent_SEQ", sequenceName = "SEQUENCE_traincomponent", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "traincomponent_SEQ")
    private int id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name = "quantity")
    private int quantity;

    public TrainComponent(){

    }

    public TrainComponent(Train train, Component component){
        this.train = train;
        this.component = component;

    }

    public String toString() {
        return component.getName() + " with id " + component.getId() + " quantity " + this.quantity;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
