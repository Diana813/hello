package resources.layouts.panels;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.Dimension;


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
