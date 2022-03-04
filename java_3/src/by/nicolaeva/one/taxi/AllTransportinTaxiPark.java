package by.nicolaeva.one.taxi;
import by.nicolaeva.one.Info;

public class AllTransportinTaxiPark extends Info implements  All{
   enum  Transport
   {
       Bus,Taxi,MiniBus,Truck
   }
        private String type;
        private String stamp;
        private int price;
        private int FuelConsumption;
        private int speed;

        public String getType() {
        return type;
    }
        public void setType(String type) {
        this.type = type;
    }

        public String getStamp() {
            return stamp;
        }
        public void setStamp(String stamp) {
            this.stamp = stamp;
        }

        public int getPrice() {return price;}
        public void setPrice(int price) { this.price = price;}

        public int getFuelConsumption() {return FuelConsumption;}
        public void setFuelConsumption(int FuelConsumption) {this.FuelConsumption = FuelConsumption;}

        public int getSpeed() {return speed;}
        public void setSpeed(int speed) {this.speed = speed;}

        public String Info() {return null;}

}
