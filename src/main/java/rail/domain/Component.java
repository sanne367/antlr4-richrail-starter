package rail.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "component", schema = "public")
public class Component {
    @Id
    @SequenceGenerator(name = "component_SEQ", sequenceName = "SEQUENCE_component", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "component_SEQ")
    private int id;

    // TODO: 12-11-2020 unique 
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "componenttype_id", referencedColumnName = "id")
    private ComponentType componentType;

    @OneToMany(mappedBy = "component")
    private List<TrainComponent> trainComponent;

    public Component(){};
    public Component(ComponentType componentType, String name){
        this.componentType = componentType;
        this.name = name;
    }

    public String toString() {
        return "Wagon: " + name + " has id: " + id + " " + componentType;
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

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }
}
