package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private ClientConnectionHandler connectionHandler;

    public Client(String nickname) {
        try {
            this.socket = new Socket("localhost", 9999);
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.connectionHandler = new ClientConnectionHandler();

        } catch (IOException e) {
            connectionHandler.closeClientConnection(socket, writer, reader);
        }
    }

    public void sendMessage() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String message = scanner.nextLine();
                writer.write(message);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            connectionHandler.closeClientConnection(socket, writer, reader);
        }
    }

    public void getMessagesFromOtherUsers() {

        new Thread(() -> {
            String messageFromChat;
            while (socket.isConnected()) {
                try {
                    messageFromChat = reader.readLine();
                    System.out.println(messageFromChat);
                } catch (IOException e) {
                    connectionHandler.closeClientConnection(socket, writer, reader);
                }
            }
        }).start();
    }

}
