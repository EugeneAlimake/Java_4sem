package Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Product {
    public String name;
    public String Country;
    public  int  weight;
    public int code;

    public Product(String name, String country, int weight, int code) {
        this.name = name;
        this.Country = country;
        this.weight = weight;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Продукт "+name+"Страна: "+Country+"вес "+weight+"штрих-код "+code;
    }
}