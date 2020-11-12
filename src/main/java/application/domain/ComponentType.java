package application.domain;

import javax.persistence.*;

@Entity
@Table(name = "componenttype")
public class ComponentType {
    @Id
    @SequenceGenerator(name = "componenttype_SEQ", sequenceName = "SEQUENCE_componenttype", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "componenttype_SEQ")
    private int id;
    private String typeName;

    public ComponentType(){};
    public ComponentType(String type){
        typeName = type;
    }

}
