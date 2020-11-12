package application.domain;


import javax.persistence.*;

@Entity
@Table(name = "traincomponent")
public class TrainComponent {

    @Id
    @SequenceGenerator(name = "traincomponent_SEQ", sequenceName = "SEQUENCE_traincomponent", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "traincomponent_SEQ")
    private int id;

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private Train theTrain;

    @ManyToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component theComponent;

    @Column(name = "quantity")
    private int quantity;

    public TrainComponent(){

    }

    public TrainComponent(Train train, Component component){
        theTrain = train;
        theComponent = component;

    }

    public String toString() {
        return "TrainComponent: belongs to " + theTrain.getName() + " with id: " + theTrain.getId() +
                " has component " + theComponent.getName() + " with id " + theComponent.getId() + " quantity " + quantity;
    }

    public Train getTheTrain() {
        return theTrain;
    }

    public void setTheTrain(Train theTrain) {
        this.theTrain = theTrain;
    }

    public Component getTheComponent() {
        return theComponent;
    }

    public void setTheComponent(Component theComponent) {
        this.theComponent = theComponent;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
