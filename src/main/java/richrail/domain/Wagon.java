package richrail.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "wagon_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Train train;

    public Wagon(){}

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "Wagon:" + this.getClass().getAnnotation(DiscriminatorColumn.class).name();
//    }
}
