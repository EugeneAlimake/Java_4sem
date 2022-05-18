package Shop;

import java.util.ArrayList;

public class Shop implements IShop{
    private final ArrayList<Product> shop;

    public Shop(){shop=new ArrayList<>();}

    @Override
    public void addProduct(Product product){shop.add(product);}

    @Override
    public void  removeProduct(Product product){shop.remove(product);}

    public ArrayList<Product> getShop(){return shop;}
}
