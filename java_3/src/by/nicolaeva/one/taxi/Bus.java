package by.nicolaeva.one.taxi;

public class Bus extends AllTransportinTaxiPark{
    public Bus(String stamp, int price,int FuelConsumption,int speed){
        setStamp(stamp);
        setType(String.valueOf(Transport.Bus));
        setPrice(price);
        setFuelConsumption(FuelConsumption);
        setSpeed(speed);
    }
    @Override
    public String Info() {
        return "Type of car : " + getType()  + "\nStamp : " + getStamp() +
                "\nPrice : " + getPrice() + "$" + "\nFuel Consumption : " + getFuelConsumption() +
                "\nSpeed : " + getSpeed();
    }
}
