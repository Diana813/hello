package resources.layouts.panels;

import javax.swing.*;

import java.awt.*;

import static client.ClientHandler.connectedClients;

public class EastPanel extends JPanel {

    public static JList connectedClientsView =new JList<String>();
    public EastPanel(){

        this.setPreferredSize(new Dimension(50, 100));
        connectedClientsView.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        connectedClientsView.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        connectedClientsView.setVisibleRowCount(-1);
        this.add(connectedClientsView);
    }
}
