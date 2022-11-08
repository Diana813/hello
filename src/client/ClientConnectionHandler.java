package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import server.ClientHandler;

/**
 * Klasa obsługująca połączenie użytkownika z serwerem
 */
public class ClientConnectionHandler {


    /**
     * Metoda zamykająca połączenie z klientem po stronie serwera
     * @param socket gniazdo reprezentujące punkt końcowy połączenia
     * @param bufferedWriter obiekt, który zapisuje tekst jako strumień znaków wyjściowych,
     *                       buforując znaki, aby zapewnić wydajne pisanie pojedynczych znaków, tablic i stringów
     * @param bufferedReader obiekt, który odczytuje tekst ze strumienia wejściowego znaków, buforując je,
     *                       aby zapewnić wydajne odczytywanie znaków, tablic i wierszy.
     * @param clientHandler obiekt klasy ClientHandler, zapewniający komunikację serwera z klientem
     */
    public void closeClientConnection(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader, ClientHandler clientHandler) {
        clientHandler.removeClientHandler();
        closeClientConnection(socket, bufferedWriter, bufferedReader);
    }

    /**
     * Metoda zamykająca połączenie z serwerem po stronie klienta
     * @param socket gniazdo reprezentujące punkt końcowy połączenia
     * @param bufferedWriter obiekt, który zapisuje tekst jako strumień znaków wyjściowych,
     *                       buforując znaki, aby zapewnić wydajne pisanie pojedynczych znaków, tablic i stringów
     * @param bufferedReader obiekt, który odczytuje tekst ze strumienia wejściowego znaków, buforując je,
     *                       aby zapewnić wydajne odczytywanie znaków, tablic i wierszy.
     */
    public void closeClientConnection(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        try {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }

            if(socket != null){
                socket.close();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
