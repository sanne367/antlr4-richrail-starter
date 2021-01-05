package richrail.domain;

public interface WagonBuilder {
    //nu simpele parameters, toekomstig uitbreidbaar met functionality
    //voorbeeld: ipv String goods krijg je een subsysteem goederen
    void setNameOfGoods(String goods);
    void setNameOfCars(String carName);
    void setSeats(int seats);
    WagonManual build();
}
