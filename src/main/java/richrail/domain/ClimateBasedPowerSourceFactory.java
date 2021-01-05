package richrail.domain;

public class ClimateBasedPowerSourceFactory implements PowerSourceFactory {
    private String climateImpact;

    public ClimateBasedPowerSourceFactory(String climateImpact){
        this.climateImpact = climateImpact;
    }

    @Override
    public PowerSource createPowerSource() {
        if(climateImpact.equals("low")){
            return new WindPowerSource();
        }
        if(climateImpact.equals("medium")){
            return new ElectricPowerSource();
        }
        return new PetroleumPowerSource();
    }
}
