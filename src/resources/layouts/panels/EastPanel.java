package resources.layouts.panels;

import client.ClientHandler;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import static resources.strings.AppStrings.usersList;
import static resources.styles.Dimensions.eastPanelDim;
import resources.widgets.AppLabel;


public class EastPanel extends Panel {

    private JList<ClientHandler> connectedClients = new JList<>();

    public EastPanel() {
        this.setPreferredSize(new Dimension(eastPanelDim, eastPanelDim));
        this.setBorder(new BasicBorders.FieldBorder(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));

        this.setBackground(null);
        this.add(new AppLabel(usersList, 15));
        this.add(connectedClients);
    }
}
