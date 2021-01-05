package richrail.domain;

public class WagonManual {
    private final String nameOfGoods;
    private final String nameOfCar;
    private final int numberOfSeats;

    public WagonManual(String nameOfGoods,String nameOfCar,int numberOfSeats){
        this.nameOfCar = nameOfCar;
        this.nameOfGoods = nameOfGoods;
        this.numberOfSeats = numberOfSeats;
    }

    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public String getNameOfCar() {
        return nameOfCar;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        String info = "";
        if(this.numberOfSeats != 0){
            info += "[NumberOfSeats]:" + this.numberOfSeats;
        }if(this.nameOfGoods != null){
            info += "[NameOfGoods]:" + this.nameOfGoods;
        }if(this.nameOfCar != null){
            info += "[NameOfCar]:" + this.nameOfCar;
        }
        return info;
    }
}
