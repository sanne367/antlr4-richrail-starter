package richrail.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Train")
public class Train {
        //implements Iterable<Wagon> {
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

    @OneToOne(cascade = CascadeType.ALL)
//    @MapsId
    private PowerSource powerSource;
//
//    private Map<Integer, Wagon> wagons = new HashMap<>();

    public Train(){};
    public Train(String name){
        this.name = name;
    }
    public Train(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

//    public Train(String name, Map<Integer, Wagon> wagons) {
//        this.name = name;
//        this.wagons = wagons;
//    }
//
//    public void add(Wagon wagon) {
//        this.wagons.put(wagon.getId(), wagon);
//    }
//
//    public void remove(int index) {
//        this.wagons.remove(index);
//    }

    public String getName() {
        return name;
    }

//    @Override
//    public Iterator<Wagon> iterator() {
//        return this.wagons.values().iterator();
//    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(name, train.name) && Objects.equals(weight, train.weight);
    }


}
