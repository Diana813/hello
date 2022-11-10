package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import static resources.strings.AppStrings.me;
import static resources.strings.AppStrings.userConnected;
import static resources.strings.AppStrings.userDisconnected;

/**
 * Klasa Serwer wykonuje zadania dotyczące rozsyłania wiadomości do wszystkich klientów
 */
public class Server {

    /**
     * Metoda odpowiadająca za rozgłaszanie wiadomości do wszystkich połączonych klientów
     * @param message wiadomość do rozgłoszenia
     * @param nickname imię klienta, odktórego pochodzi wiadomość
     * @param connectedClients lista połączonych klientów
     */
    public void broadcastMessage(String message, String nickname, ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> {
            if (!it.nickname.equals(nickname)) {
                it.sendMessage(nickname + ": " + message);
            } else {
                it.sendMessage(String.format(me + " %s", message));
            }
        });
    }

    /**
     * Metoda odpowiadająca za rozgłoszenie informacji o połączeniu się nowego klienta
     * @param nickname imię połączonego klienta
     * @param connectedClients lista połączonych użytkowników
     */
    public void broadcastUserConnectedInfo(String nickname, ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> it.sendMessage(userConnected(nickname)));
    }

    /**
     * Metoda rozgłaszająca listę połączonych użytkowników
     * @param connectedClients lista połączonych użytkowników
     */
    public void broadcastConnectedUsersList(ArrayList<ClientHandler> connectedClients) {
        for (ClientHandler it : connectedClients) {
            it.sendConnectedUsersList(connectedClients.stream().map(Object::toString).toList());
        }
    }

    /**
     * Metoda rozgłaszająca informację o zakończeniu połączenia przez jednego z użytkowników
     * @param nickname imię użytkownika opuszczającego rozmowę
     * @param connectedClients lista połączonych użytkowników
     */
    public void broadcastUserDisconnectedInfo(String nickname, ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> it.sendMessage(userDisconnected(nickname)));
    }


    /**
     * Metoda uruchamijąca działanie aplikacji Server
     * @param args argumenty wiersza poleceń Java.
     * @throws IOException wyjątek generowany przez nieudane operacje wejścia/wyjścia
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        ServerConnectionHandler connectionHandler = new ServerConnectionHandler(serverSocket);
        connectionHandler.startServer();
    }
}
