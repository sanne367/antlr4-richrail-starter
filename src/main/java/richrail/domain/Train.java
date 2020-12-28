package richrail.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Train")
public class Train implements Iterable<Wagon> {
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
    private PowerSource powerSource;

//    @OneToMany(cascade = CascadeType.ALL)
//    //@ElementCollection
//    @JoinTable(name = "train_wagons",
//            joinColumns = {@JoinColumn(name = "train_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "wagon_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "wagon_type")
//    //@Column(name = "wagons_id")
//    private Map<Integer, Wagon> wagons = new HashMap<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Wagon> wagons = new ArrayList<>();

    public Train(){};
    public Train(String name){
        this.name = name;
    }
    public Train(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Train(String name, List<Wagon> wagons) {
        this.name = name;
        this.wagons = wagons;
    }

    public void add(Wagon wagon) {
        if(wagons.contains(wagon)){
            int index = wagons.indexOf(wagon);
            wagons.get(index).setQuantity(wagons.get(index).getQuantity()+1);
        }
        this.wagons.add(wagon);
    }

    public void remove(Wagon wagon){
        if(wagons.contains(wagon)){
            int index = wagons.indexOf(wagon);
            if(wagons.get(index).getQuantity() >2){
                wagons.get(index).setQuantity(wagons.get(index).getQuantity() -1);
            }
            this.wagons.remove(wagon);
        }
    }

    public void remove(int index) {
        this.wagons.remove(index);
    }

    public String getName() {
        return name;
    }

    @Override
    public Iterator<Wagon> iterator() {
        return this.wagons.iterator();
    }

    public List<Wagon> getWagons() {
        return wagons;
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
        return "Train: " + this.name + " " + this.powerSource + " " + this.wagons;
    }


}
