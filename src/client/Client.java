package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import resources.layouts.ChatLayout;
import resources.layouts.panels.MainPanel;
import resources.layouts.panels.WestPanel;
import static resources.strings.AppStrings.userRemoved;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private ClientConnectionHandler connectionHandler;
    private final WestPanel westPanel;
    private final MainPanel mainPanel;

    public Client(WestPanel westPanel, MainPanel mainPanel) {
        this.westPanel = westPanel;
        this.mainPanel = mainPanel;
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
        if (isElementFromConnectedUsersList(message)) {
            westPanel.displayConnectedUser(getUsernameFromServerMessage(message, "user: "));
        }else if(isUserDisconnectedInfo(message)){
            westPanel.removeDisconnectedUserFromTheList(getUsernameFromServerMessage(message, userRemoved));
            mainPanel.displayMessage(message);
        } else {
            mainPanel.displayMessage(message);
        }
    }

    private String getUsernameFromServerMessage(String message, String substringToRemove){
        return message.replace(substringToRemove, "").trim();
    }

    private boolean isElementFromConnectedUsersList(String message){
        return message.contains("user: ");
    }

    private boolean isUserDisconnectedInfo(String message){
        return message.contains(userRemoved);
    }

    public static void main(String[] args) {
        new ChatLayout();
    }

}
