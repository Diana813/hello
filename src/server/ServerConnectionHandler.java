package server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Klasa ServerConnectionHandler obsługuje połączenie serwera z klientami
 */
public class ServerConnectionHandler {

    private final ServerSocket serverSocket;

    /**
     * Tworzy obiekt klasy ServerConnectionHandler
     * @param serverSocket to gniazdo serwera, które czeka na żądania przychodzące przez sieć
     */
    public ServerConnectionHandler(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Metoda uruchamiająca serwer
     */
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

    /**
     * Metoda zamykająca gniazdo serwera
     */
    public void closeServer() {
        try {
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
