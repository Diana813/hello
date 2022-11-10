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

/**
 * Klasa Client odpowiedzialna za tworzenie nowego użytkownika
 */
public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private ClientConnectionHandler connectionHandler;
    private final WestPanel westPanel;
    private final MainPanel mainPanel;

    /**
     * Tworzy nowy obiekt klasy Client i łączy go z serwerem
     * @param westPanel kontener do wyświetlania listy użytkowników
     * @param mainPanel kontener do wyświetlania wiadomości od użytkowników
     */
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

    /**
     * Metoda wysyłająca strumień danych do serwera
     * @param message wiadomość do wysłania
     */
    public void sendMessage(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            connectionHandler.closeClientConnection(socket, writer, reader);
        }
    }

    /**
     * Metoda oczekująca na strumień danych z serwera (w osobnym wątku)
     */
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

    /**
     * Metoda przekazująca odebrane z serwera dane do odpowiedniego kontenera w celu prawidłowego wyświetlenia wiadimości
     * @param message wiadomość do wyświetlenia
     */
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

    /**
     * Metoda ekstrahująca imię użytkownika z otrzymanej informacji o połączonych użytkownikach
     * @param message otrzymana wiadomość z serwera
     * @param substringToRemove część wiadomości, którą należy usunąć
     * @return imię użytkownika
     */
    private String getUsernameFromServerMessage(String message, String substringToRemove){
        return message.replace(substringToRemove, "").trim();
    }

    /**
     * Metoda sprawdzająca, czy otrzymana wiadomość jest elementem listy połączonych użytkowników wysyłanej przez serwer
     * @param message otrzymana wiadomość
     * @return true lub false
     */
    private boolean isElementFromConnectedUsersList(String message){
        return message.contains("user: ");
    }

    /**
     * Metoda sprawdzająca, czy otrzymana wiadomość jest informacją z serwera o opuszczeniu rozmowy przez użytkownika
     * @param message otrzymana wiadomość
     * @return true lub false
     */
    private boolean isUserDisconnectedInfo(String message){
        return message.contains(userRemoved);
    }

    /**
     * Metoda uruchamiająca aplikację użytkownika
     * @param args argumenty wiersza poleceń Java.
     */
    public static void main(String[] args) {
        new ChatLayout();
    }

}
