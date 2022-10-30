package client;

import org.w3c.dom.Text;
import server.Server;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

import static resources.layouts.panels.EastPanel.connectedClientsView;


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
            connectedClientsView.add(new JLabel(this.nickname));
            server.broadcastUserConnectedInfo(nickname, connectedClients);

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


    public void removeClientHandler() {
        int index = connectedClients.indexOf(this);
        connectedClients.remove(index);
        connectedClientsView.remove(index);
        server.broadcastUserDisconnectedInfo(nickname, connectedClients);
    }
}
