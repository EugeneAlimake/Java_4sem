package by.nicolaeva.one.taxipark;
import by.nicolaeva.one.delete.DeleteList;
import by.nicolaeva.one.taxi.AllTransportinTaxiPark;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.*;
import java.lang.reflect.Array;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

public class TaxiPark {
    public static List<AllTransportinTaxiPark> alllist = new ArrayList<>();
    private final static Logger logger = LogManager.getLogger(TaxiPark.class);
    public TaxiPark(AllTransportinTaxiPark... transport) throws DeleteList {
        for (AllTransportinTaxiPark elements : transport) {
            alllist.add(elements);
            logger.info("Add element");
        }
    }

    public void Delete(AllTransportinTaxiPark obj) throws DeleteList {
        if (!alllist.isEmpty()) {
            alllist.remove(obj);
            logger.info("remove element");

        } else {
            throw new DeleteList("The list is empty");
        }
    }

    public void getElements() {
        for (AllTransportinTaxiPark elements : alllist) {
            System.out.println("Type of car : " + elements.getType() + "\nStamp : " + elements.getStamp() +
                    "\nPrice : " + elements.getPrice() + "$" + "\nFuel Consumption : " + elements.getFuelConsumption() +
                    "\nSpeed : " + elements.getSpeed() + "\n");
        }

    }
    public void getElements(String path){
        try(FileWriter fw = new FileWriter(path,true)){
            for (AllTransportinTaxiPark elements :alllist) {
                fw.write("Type of car : " + elements.getType() + "\nStamp : " + elements.getStamp() +
                        "\nPrice : " + elements.getPrice() + "$" + "\nFuel Consumption : " + elements.getFuelConsumption() +
                        "\nSpeed : " + elements.getSpeed() + "\n");
            }
            logger.info("Writing to file was successful");
        }
        catch(IOException e){
            System.out.println("Error : " + e.getMessage());
            logger.error(e);
        }
    }
    public static class Manager {
        public static void sortFuelFlow() {
            Collections.sort(alllist, (o1, o2) -> o1.getFuelConsumption() < o2.getFuelConsumption() ? -1 : (o1.getFuelConsumption() > o2.getFuelConsumption()) ? 1 : 0);
        }

        public static void sumTaxiPark() {
            int sum = 0;
            for (AllTransportinTaxiPark elements : alllist) {
                sum = sum + elements.getPrice();
            }
            System.out.println("Sum of Taxi Park is : " + sum);
        }

        public static void findMarks(int minSpeed, int maxSpeed) {
            for (AllTransportinTaxiPark elements : alllist) {
                if (elements.getSpeed() >= minSpeed && elements.getSpeed() <= maxSpeed) {
                    System.out.println("Mark for range [" + minSpeed + " , " + maxSpeed + "] : " + elements.getStamp());
                }
            }
        }
    }
}
