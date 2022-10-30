package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class ClientConnectionHandler {

    public void closeClientConnection(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader, ClientHandler clientHandler) {
        clientHandler.removeClientHandler();
        closeClientConnection(socket, bufferedWriter, bufferedReader);
    }

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
