package application.domain;

import javax.persistence.*;

@Entity
@Table(name = "component")
public class Component {
    @Id
    @SequenceGenerator(name = "component_SEQ", sequenceName = "SEQUENCE_component", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "component_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "componenttype_id", referencedColumnName = "id")
    private ComponentType componentType;

    public Component(){};
    public Component(ComponentType componentType, String name){
        this.componentType = componentType;
        this.name = name;
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
