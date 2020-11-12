package application.domain;

import javax.persistence.*;

@Entity
@Table(name = "componenttype")
public class ComponentType {
    @Id
    @SequenceGenerator(name = "componenttype_SEQ", sequenceName = "SEQUENCE_componenttype", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "componenttype_SEQ")
    private int id;

    @Column(name = "name")
    private String name;

    public ComponentType(){};
    public ComponentType(String type){
        name = type;
    }

    public String toString() {
        return "Componenttype: " + name + " has id: " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}
