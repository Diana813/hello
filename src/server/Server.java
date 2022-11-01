package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import static resources.strings.AppStrings.userConnected;
import static resources.strings.AppStrings.userDisconnected;


/**
 * Implementacja interfejsu Runnable pozwala na uruchomienie klasy w osobnym wątku
 */

public class Server {

    public void broadcastMessage(String message, String nickname, ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> {
            if (!it.nickname.equals(nickname)) {
                it.sendMessage(nickname + ": " + message);
            } else {
                it.sendMessage(String.format("Me: %s", message));
            }
        });
    }

    public void broadcastUserConnectedInfo(String nickname, ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> it.sendMessage(userConnected(nickname)));
    }

    public void broadcastConnectedUsersList(ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> {
            it.sendConnectedUsersList(connectedClients.stream().map(Object::toString).toList());
        });
    }

    public void broadcastUserDisconnectedInfo(String nickname, ArrayList<ClientHandler> connectedClients) {
        connectedClients.forEach(it -> it.sendMessage(userDisconnected(nickname)));
    }


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        ServerConnectionHandler connectionHandler = new ServerConnectionHandler(serverSocket);
        connectionHandler.startServer();
    }
}
