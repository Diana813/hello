package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import resources.layouts.ChatLayout;
import static resources.layouts.panels.EastPanel.connectedClientsListModel;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private ClientConnectionHandler connectionHandler;

    public Client() {
        try {
            this.socket = new Socket("localhost", 9999);
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.connectionHandler = new ClientConnectionHandler();

        } catch (IOException e) {
            connectionHandler.closeClientConnection(socket, writer, reader);
        }
    }

    public void sendMessage(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();

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
                    displayMessage(messageFromChat);
                } catch (IOException e) {
                    connectionHandler.closeClientConnection(socket, writer, reader);
                }
            }
        }).start();
    }

    private void displayMessage(String message) {
        if (message.contains("user: ")) {
            connectedClientsListModel.addElement(message.replace("user: ", ""));
        } else {

        }
    }

    public static void main(String[] args) {
        new ChatLayout();
    }
}
