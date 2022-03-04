package by.nicolaeva.one.taxi;

public class Taxi extends AllTransportinTaxiPark{
    public Taxi(String stamp, int price,int getFuelConsumption,int speed){
        setStamp(stamp);
        setType(String.valueOf(Transport.Taxi));
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
