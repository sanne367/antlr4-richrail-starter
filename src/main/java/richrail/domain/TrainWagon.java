package richrail.domain;

import javax.persistence.*;

@Entity
public class TrainWagon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name="wagon_id")
    private Wagon wagon;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    // TODO: 31-12-2020 check weight & check quantity


    @Override
    public String toString() {
        return quantity + " : " + wagon;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject instanceof TrainWagon) {
            TrainWagon otherWagon = (TrainWagon) otherObject;

            if (this.train.equals(otherWagon.train) &&
                    this.wagon.equals(otherWagon.wagon))
                return true;
        }
        return false;
    }
}
