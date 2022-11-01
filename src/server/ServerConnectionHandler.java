package server;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionHandler {

    private final ServerSocket serverSocket;

    public ServerConnectionHandler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket client = serverSocket.accept();
                ClientHandler connectedClient = new ClientHandler(client);
                Thread thread = new Thread(connectedClient);
                thread.start();
            }

        } catch (Exception e) {
            closeServer();
        }
    }

    public void closeServer() {
        try {
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
