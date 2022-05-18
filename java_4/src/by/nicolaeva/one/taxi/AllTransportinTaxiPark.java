package by.nicolaeva.one.taxi;
import by.nicolaeva.one.Info;

public class AllTransportinTaxiPark extends Info implements  All{
   enum  Transport
   {
       Bus,Taxi,MiniBus,Truck
   }
        public String types;
        public String stamp;
        public int price;
        public int FuelConsumption;
        public int speed;


        public String Info() {return null;}

}
