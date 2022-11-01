package server;

import client.ClientConnectionHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientHandler implements Runnable {

    public static final ArrayList<ClientHandler> connectedClients = new ArrayList<>();

    private Socket client;
    private BufferedReader reader;
    private BufferedWriter writer;
    public String nickname;
    private Server server;
    private ClientConnectionHandler connectionHandler;

    public ClientHandler(Socket client) {
        try {
            this.client = client;
            this.server = new Server();
            this.connectionHandler = new ClientConnectionHandler();
            this.writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.nickname = reader.readLine();
            connectedClients.add(this);
            server.broadcastUserConnectedInfo(nickname, connectedClients);
            server.broadcastConnectedUsersList(connectedClients);

        } catch (IOException e) {
            connectionHandler.closeClientConnection(client, writer, reader, this);
        }

    }

    @Override
    public void run() {
        String message;

        while (client.isConnected()) {

            try {
                message = reader.readLine();
                server.broadcastMessage(message, nickname, connectedClients);

            } catch (IOException e) {
                connectionHandler.closeClientConnection(client, writer, reader, this);
                break;
            }
        }
    }

    public void sendMessage(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            connectionHandler.closeClientConnection(client, writer, reader, this);
        }
    }

    public void sendConnectedUsersList(List<String> connectedUsers) {
        connectedUsers.forEach(user -> {
            try {
                writer.write("user: " + user);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                connectionHandler.closeClientConnection(client, writer, reader, this);
            }
        });
    }


    public void removeClientHandler() {
        connectedClients.remove(this);
        server.broadcastUserDisconnectedInfo(nickname, connectedClients);
    }

    @Override
    public String toString() {
        return nickname;
    }
}