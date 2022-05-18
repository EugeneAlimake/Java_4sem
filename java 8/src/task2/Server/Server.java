package task2.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static final int PORT = 4004;
    public static LinkedList<ServerThread> serverThreads = new LinkedList<>();
    public static MessageStory messageStory;

    public static void main(String[] args) throws IOException {
        //Установка соединения на стороне клиента
        ServerSocket server = new ServerSocket(PORT);
        messageStory = new MessageStory();
        //Сервер создает сокет, который будет использоваться
        //для связи с клиентом
        System.out.println("Server is listening on port " + PORT);
        try {
            while (true) {
                Socket socket = server.accept();
                //ожидает клиента и возвращает его сокет
                try {
                    serverThreads.add(new ServerThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}