package richrail.domain;

public class WeightBasedPowerSourceFactory implements PowerSourceFactory {
    private int weight;

    public WeightBasedPowerSourceFactory(int weight){
        this.weight = weight;
    }

    //create powersource based on chosen weight in runtime

    public PowerSource createPowerSource(){
        if(weight <= 300){
            return new WindPowerSource();
        }
        if(weight <= 4000){
            return new ElectricPowerSource();
        }
        return new PetroleumPowerSource();
    }

}
