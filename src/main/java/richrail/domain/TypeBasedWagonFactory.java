package richrail.domain;

public class TypeBasedWagonFactory implements WagonFactory {
    // TODO: 5-1-2021 factory meerdere parameters, abstract factory of builder of wat nodig? 
    // TODO: 5-1-2021 nu opgelost met generieke value ivm database veld maar nietuibredivaar nu
    // TODO: 5-1-2021 willen met builder dynamisch maken
    protected Wagon wagonClass;
    private int weight;
    private String value;
    private String typeName;

    public TypeBasedWagonFactory(Wagon wagonClass, String value, int weight, String typeName){
        this.value = value;
        this.typeName = typeName;
        this.weight = weight;
        this.wagonClass = wagonClass;
    }

    @Override
    public Wagon createWagon() {
        if(wagonClass.getClass() == CarWagon.class){
            return new CarWagon(this.value, this.weight, this.typeName);
        }
        if(wagonClass.getClass() == CargoWagon.class){
            return new CargoWagon(this.value, this.weight, this.typeName);
        }
        return new PersonWagon(this.value, this.weight, this.typeName);
    }
}
