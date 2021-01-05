package richrail.domain;

public class WagonManualBuilder implements WagonBuilder{
    private String nameOfGoods;
    private String nameOfCar;
    private int numberOfSeats;


    @Override
    public void setNameOfGoods(String goods) {
        this.nameOfGoods = goods;
    }

    @Override
    public void setNameOfCars(String carName) {
        this.nameOfCar = carName;
    }

    @Override
    public void setSeats(int seats) {
        this.numberOfSeats = seats;
    }

    public WagonManual build(){
        return new WagonManual(nameOfGoods, nameOfCar, numberOfSeats);

    }
}
