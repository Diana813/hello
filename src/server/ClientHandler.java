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

/**
 * Klasa ClientHandler odpowiadająca za komunikację serwera z wieloma klientami.
 * Implementacja interfejsu Runnable pozwala na uruchomienie klasy w osobnym wątku.
 */
public class ClientHandler implements Runnable {

    public static final ArrayList<ClientHandler> connectedClients = new ArrayList<>();

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    public String nickname;
    private Server server;
    private ClientConnectionHandler connectionHandler;

    /**
     * Tworzy nowy obiekt klasy ClientHandler
     * @param socket gniazdo służące do odbierania i wysyłania danych
     */
    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.server = new Server();
            this.connectionHandler = new ClientConnectionHandler();
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.nickname = reader.readLine();
            connectedClients.add(this);
            server.broadcastUserConnectedInfo(nickname, connectedClients);
            server.broadcastConnectedUsersList(connectedClients);

        } catch (IOException e) {
            connectionHandler.closeClientConnection(socket, writer, reader, this);
        }

    }

    /**
     * Metoda nadpisująca metodę run() interfejsu Runnable, służąca do nieustannego nasłuchiwania informacji od
     * połączonego przez dany socket klienta i rozgłaszająca te informacje do wszystkich klientów
     */
    @Override
    public void run() {
        String message;

        while (socket.isConnected()) {
            try {
                message = reader.readLine();
                server.broadcastMessage(message, nickname, connectedClients);
            } catch (IOException e) {
                connectionHandler.closeClientConnection(socket, writer, reader, this);
                break;
            }
        }
    }

    /**
     * Metoda odpowiadająca za wysyłanie strumienia danych z serwera do klienta
     * @param message wiadomość do wysłania
     */
    public void sendMessage(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            connectionHandler.closeClientConnection(socket, writer, reader, this);
        }
    }

    /**
     * Metoda wysyłająca listę połaczonych użytkowników do wszystkich klientów
     * @param connectedUsers lista połączonych klientów
     */
    public void sendConnectedUsersList(List<String> connectedUsers) {
        connectedUsers.forEach(user -> {
            try {
                writer.write("user: " + user);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                connectionHandler.closeClientConnection(socket, writer, reader, this);
            }
        });
    }

    /**
     * Metoda usuwająca klienta z listy połączonych użytkowników i rozgłaszająca informację o tym do pozostałych
     * klientów
     */
    public void removeClientHandler() {
        connectedClients.remove(this);
        server.broadcastUserDisconnectedInfo(nickname, connectedClients);
    }

    /**
     * Metoda nadpisująca metodę toString() klasy ClientHandler
     * @return imię klienta
     */
    @Override
    public String toString() {
        return nickname;
    }
}
