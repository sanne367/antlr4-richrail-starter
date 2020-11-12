package application.domain;


import javax.persistence.*;

@Entity
@Table(name = "traincomponent")
public class TrainComponent {

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
