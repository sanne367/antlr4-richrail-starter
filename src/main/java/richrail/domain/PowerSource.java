package richrail.domain;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "power_source_type", discriminatorType = DiscriminatorType.STRING)
public abstract class PowerSource {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    protected int maxWeight;

    @Column
    protected String climateImpact;

    public PowerSource(){};

    public PowerSource(int maxWeight, String climateImpact){
        this.maxWeight = maxWeight;
        this.climateImpact = climateImpact;
    }

    public String getClimateImpact() {
        return climateImpact;
    }

    public void setClimateImpact(String climateImpact) {
        this.climateImpact = climateImpact;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[MAXWEIGHT]:" + this.maxWeight + " [CLIMATEIMPACT]:" + this.climateImpact;
    }
}
