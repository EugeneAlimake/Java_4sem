package Shop;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class ShopTest1 {
  Product apple=new Product("apple","Belarus",1000,45563214);
    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod- запуск перед каждого тестового метода.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod – запуск после каждого тестового метода.");
    }

    @BeforeGroups
    public void BeforeGroups() {
        System.out.println("BeforeGroups – аннотирует методы, которые будут выполняться перед первым методом в любой из указанных групп.");
    }

    @AfterGroups
    public void AfterGroups() {
        System.out.println("@AfterGroups – аннотируется методы, которые будут выполняться после всех методом в любом из указанных групп.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass – указывает, что метод будет выполнен до всех тестовых методов тестового класса.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass  – аннотированный метод будет запущен после всех тестовых методов в текущем классе.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - аннотированный метод будет запускаться до всех тестовых методов.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest – аннотированный метод будет запущен после всех тестовых методов, принадлежащих классам внутри тега <test>.");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite – указывает, что данный метод будет запускаться перед любым методом тестового класса.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite – указывает, что данный метод, будет запускаться после всех методов тестового класса.");
    }


    @Test(groups = {"unit"})
    public void testAddProduct() {
        Shop shop = new Shop();
        shop.addProduct(apple);
        Assert.assertNotNull(shop);
    }

    @Test(timeOut = 1000)
    public void testRemoveProduct() {
        Shop shop2 = new Shop();
        shop2.addProduct(apple);
        shop2.removeProduct(apple);

        Assert.assertNotNull(shop2.getShop());
    }

    @Test(enabled = false)
    public void testGetShop() {
    }
    @DataProvider
    public Object[][] datas() {
        return new Object[][] {
                { new Product("banana", "Turkey", 1500,12544)},
                { new Product("watermelon", "Turkey", 10000,2345)}
        };
    }
    @Test(dataProvider = "datas")
    public void testAdd(Product a) throws Exception {
        Assert.assertNotNull(a);
        System.out.println(a);
    }


}