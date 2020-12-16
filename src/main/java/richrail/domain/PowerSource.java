package richrail.domain;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "power_source_type", discriminatorType = DiscriminatorType.STRING)
public abstract class PowerSource {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public PowerSource(){}
}
