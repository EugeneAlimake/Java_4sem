package by.nicolaeva.one.taxi;

public class Minibus extends AllTransportinTaxiPark{
    public Minibus(String stamp, int price,int FuelConsumption,int speed)
    {
        this.stamp=stamp;
        types= String.valueOf(Transport.Bus);
        this.price=price;
        this.FuelConsumption=FuelConsumption;
        this.speed=speed;
    }
    @Override
    public String Info() {
        System.out.println("Type of car : " + stamp  + "\nStamp : " + types +
                "\nPrice : " + price + "$" + "\nFuel Consumption : " + FuelConsumption +
                "\nSpeed : " + speed);
        return null;
    }
}
