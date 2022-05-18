package task1;
import java.io.InputStreamReader;
import java.net.*;


public class Main {
    public static void main(String[] args) throws UnknownHostException {
        var connection = new Connect();
        connection.getLocalHost();
        connection.getByName("www.belstu.by");
        byte ip[] = {(byte) 127, (byte) 0, (byte) 0, (byte) 7};
        connection.DefiningAccess("Unknown", ip);
        URL tut = null;
        connection.Httpread("https://www.onliner.by");
        connection.ConnectInfo("https://www.onliner.com");
    }
}
