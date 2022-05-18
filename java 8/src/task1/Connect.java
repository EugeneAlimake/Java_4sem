package task1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Connect {
    public void getLocalHost()
    {
        try {
            var currentIP = InetAddress.getLocalHost(); // вывод IP-адреса локального компьютера
            System.out.println("IP -> " + currentIP.getHostAddress());
        } catch (UnknownHostException e) { // если не удается найти IP
            System.err.println(e.getMessage());
        }
    }
    public void getByName(String web) {
        try {
            var Ip = InetAddress.getByName(web);
            System.out.println("IP -> " + Ip.getHostAddress());
        }
        catch (UnknownHostException e) { // если не удается найти IP
            System.err.println(e.getMessage());
        }
    }
    public  void DefiningAccess(String name,byte[] web)
    {
        try {
            InetAddress addr = InetAddress.getByAddress(name, web);
            System.out.println(addr.getHostName()
                    + "-> cоединение:" + addr.isReachable(100));
        } catch (UnknownHostException e) {
            System.err.println("адрес недоступен " + e);
        } catch (IOException e) {
            System.err.println("ошибка " + e);
        }
    }
    public void Httpread(String urlName)
    {   URL tut = null;
        try {
            tut = new URL(urlName);
        } catch (MalformedURLException e) {
// некорректно заданы протокол, доменное имя или путь к файлу
            e.printStackTrace();
        }
        if (tut == null) {
            throw new RuntimeException();
        }
        try (BufferedReader d = new BufferedReader
                (new InputStreamReader(tut.openStream())))
        {
            String line = "";
            while ((line = d.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); }
    }
    public void ConnectInfo(String urlName)
    {   int timeout = 10_000;
        try {
            URL url = new URL(urlName);
            final URLConnection connection1 = url.openConnection();
// установка таймаута на соединение
            connection1.setConnectTimeout(timeout);
            System.out.println(urlName + " content type: "+
                    "\n" + connection1.getContentType()+
                    "\n" +connection1.getClass()+
                    "\n" + connection1.getContentLength());
// продолжение извлечения информации из соединения
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }}
}

