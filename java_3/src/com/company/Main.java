package com.company;

import by.nicolaeva.one.delete.DeleteList;
import by.nicolaeva.one.taxi.AllTransportinTaxiPark;
import by.nicolaeva.one.taxi.Bus;
import by.nicolaeva.one.taxi.Minibus;
import by.nicolaeva.one.taxi.Truck;
import by.nicolaeva.one.taxi.Taxi;
import by.nicolaeva.one.taxipark.TaxiPark;
import by.nicolaeva.one.taxipark.TaxiPark.Manager;

public class Main {

    public static void main(String[] args) throws DeleteList {

        AllTransportinTaxiPark schoolbus = new Bus("BMW", 30000, 60,15);
        AllTransportinTaxiPark taximacsim = new Taxi("Mercides", 40000, 30,80);
        TaxiPark taxiPark=new TaxiPark( taximacsim,schoolbus);
        taxiPark.getElements();
        taxiPark.getElements("logger.txt");
        Manager.sumTaxiPark();
        Manager.findMarks(70, 100);
        Manager.sortFuelFlow();
        taxiPark.getElements();
    }
}
