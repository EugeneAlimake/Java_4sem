package task3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SendUDP {
    private DatagramSocket socket; //cоздает сокет присоединяется к любому
    // свободному порту на локальной машине

    public SendUDP(int port) throws SocketException {
        socket = new DatagramSocket(port); //создаваемый сокет присоединяется к
        // порту port на локальной машине

    }

    public void sendMessages(String messages, int port) throws IOException {
        DatagramPacket message = new DatagramPacket(messages.getBytes(), messages.getBytes().length, InetAddress.getLocalHost(), port);
        // отправку
        socket.send(message);// отправить дейтаграмму
      //  упакованную в пакет
    }

    public static void main(String[] args) throws IOException {
        SendUDP udp = new SendUDP(1234);
        udp.sendMessages("message", 4321);//прием
    }
}