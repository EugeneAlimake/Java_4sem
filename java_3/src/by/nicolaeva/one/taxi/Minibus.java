package by.nicolaeva.one.taxi;

public class Minibus extends AllTransportinTaxiPark{
    public Minibus(String stamp, int price,int getFuelConsumption,int speed){
        setStamp(stamp);
        setType(String.valueOf(Transport.MiniBus));
        setPrice(price);
        setFuelConsumption(getFuelConsumption);
        setSpeed(speed);
    }
    @Override
    public String Info() {
        return "Type of car : " + getType()  + "\nStamp : " + getStamp() +
                "\nPrice : " + getPrice() + "$" + "\nFuel Consumption : " + getFuelConsumption() +
                "\nSpeed : " + getSpeed();
    }
}
