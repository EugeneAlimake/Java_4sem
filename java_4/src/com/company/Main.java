package com.company;

import by.nicolaeva.one.delete.DeleteList;
import by.nicolaeva.one.lab4.SaxParser;
import by.nicolaeva.one.taxi.AllTransportinTaxiPark;
import by.nicolaeva.one.taxi.Bus;
import by.nicolaeva.one.taxi.Minibus;
import by.nicolaeva.one.taxi.Truck;
import by.nicolaeva.one.taxi.Taxi;
import by.nicolaeva.one.taxipark.TaxiPark;
import by.nicolaeva.one.taxipark.TaxiPark.Manager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws DeleteList, SAXException, ParserConfigurationException, IOException {


        AllTransportinTaxiPark schoolbus = new Bus("BMW", 30000, 60,15);
        AllTransportinTaxiPark taximacsim = new Taxi("Mercides", 40000, 30,80);
        TaxiPark taxiPark=new TaxiPark( taximacsim,schoolbus);
        taxiPark.Add(schoolbus);
        taxiPark.getElements();
        taxiPark.getElements("logger.txt");
        Manager.sumTaxiPark();
        Manager.findMarks(70, 100);
        Manager.sortFuelFlow();
        taxiPark.getElements();
        schoolbus.Info();
       SAXParserFactory factory = SAXParserFactory.newInstance();
       //Создает новый экземпляр встроенной реализации системы по умолчанию.SAXParserFactory
        SAXParser parser = factory.newSAXParser();
        //Получение нового экземпляра платформы .
        SaxParser saxp = new SaxParser();
        //Создает новый экземпляр SAXParser с использованием настроенных в данный момент заводских параметров.
        parser.parse(new File("filexml/information.xml"),saxp);
        Bus Bobby = saxp.getResult();
        taxiPark.Add(Bobby);
        try {
            SchemaFactory factor = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            //Получите новый экземпляр имени класса from.SchemaFactory
            File schemaLocation = new File("filexml/information.xsd");
            Schema schema = factor.newSchema(schemaLocation);
            //Анализирует указанный источник как схему и возвращает его как схему.
            Validator validator = schema.newValidator();
            Source source = new StreamSource("filexml/information.xml");
            validator.validate(source);
            logger.info("Validate xml document");
        }
        catch (SAXException | Error var9) {
            System.out.println("Ошибка: " + var9);
        } catch (IOException e) {
            e.printStackTrace();
        }
        taxiPark.getElements();
        //--Сериализация XML
        System.out.println("--------------Сериализация XML------------------");
        FileOutputStream out = new FileOutputStream("filexml/Serialize.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(out);
        //XMLEncoder класс является дополнительной альтернативой ObjectOutputStream и
        //может используемый, чтобы генерировать текстовое представление JavaBean
        // таким же образом что ObjectOutputStream может использоваться, чтобы
        // создать двоичное представление Serializable объекты.
        xmlEncoder.writeObject(schoolbus);
        xmlEncoder.close();
        //--Десиреализация XML
        System.out.println("--------------Десериализация XML------------------");
        FileInputStream in = new FileInputStream("filexml/Serialize.xml");
        XMLDecoder xmlDecoder = new XMLDecoder(in);
        Bus Bobby2 = (Bus) xmlDecoder.readObject();
        xmlDecoder.close();
        Bobby2.Info();
        //--Сериализация Json
        System.out.println("-----------------Сериализация JSON---------------");
        Gson gson = new GsonBuilder().create();//создать экземпляр класса
        String json = gson.toJson(Bobby);
        System.out.println(json);
        FileOutputStream jsonOut = new FileOutputStream("filexml/Serialize.json");
        byte[] outText = json.getBytes(StandardCharsets.UTF_8);
        jsonOut.write(outText, 0, outText.length);
        //--Десериализация Json
       System.out.println("--------------Десериализация JSON---------------");
        Scanner scanner = new Scanner(new File("filexml/Serialize.json"));
        String res = "";
        while(scanner.hasNext())
            res += scanner.nextLine();
        scanner.close();
        Bus m3 = gson.fromJson(res, Bus.class);
        m3.Info();
        //--Stream API
        //Stream API — это новый способ работать со структурами данных в функциональном стиле.
        //это по своей сути поток данных
        System.out.println("-------------------Stream API-------------");
        ArrayList<AllTransportinTaxiPark> h = new ArrayList<AllTransportinTaxiPark>();
        h.add(schoolbus);
        h.add(taximacsim);
        Stream<AllTransportinTaxiPark> res_stream = h.stream().filter(w -> w.speed> 10);
        //создания экземпляра Stream, который опирается на нужную нам коллекцию,
        for(var x: res_stream.collect(Collectors.toList()))
        {
            System.out.println(x.types + " " + x.stamp);
        }
        System.out.println("----------------------------------");
        Stream<AllTransportinTaxiPark> res_stream2 = h.stream().limit(2);
        for(var x: res_stream2.collect(Collectors.toList()))
        {
            System.out.println(x.types + " " + x.stamp);
        }
    }
}

