package by.nicolaeva.one.lab4;


import by.nicolaeva.one.taxi.AllTransportinTaxiPark;
import by.nicolaeva.one.taxi.Bus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;//библотека для саксирования

public class SaxParser extends DefaultHandler {
    Bus bus1 ;
    String thisElement = "";
    @Override
    public void startDocument() throws SAXException {
        System.out.println("----> Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }
    String bname = null;
    int bprice = 0;
    int bFuelConsumption = 0;
    int bspeed = 0;
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (thisElement.equals("stamp")) {
            bname = (new String(ch, start, length));
        }
        if (thisElement.equals("price")) {
            bprice = (new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("FuelConsumption")) {
            bFuelConsumption = (new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("speed")) {
            bspeed = (new Integer(new String(ch, start, length)));
        }
        bus1 = new Bus(bname, bprice, bFuelConsumption, bspeed);
    }
    public Bus getResult()
    {
        return bus1;
    }


    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() {
        System.out.println("----> Stop parse XML...");
    }
}
