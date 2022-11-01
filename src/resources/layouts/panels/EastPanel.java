package resources.layouts.panels;

import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import static resources.strings.AppStrings.usersList;
import static resources.styles.AppColours.appNavyBlueLight;
import static resources.styles.AppColours.appOrange;
import static resources.styles.AppFonts.setAppLabelFont;
import static resources.styles.Dimensions.eastPanelDim;
import resources.widgets.AppLabel;


public class EastPanel extends Panel {

    public JList<String> connectedClients = new JList<>();
    public DefaultListModel<String> connectedClientsListModel = new DefaultListModel<>();

    public EastPanel() {
        this.setPreferredSize(new Dimension(eastPanelDim, eastPanelDim));
        connectedClients.setBackground(null);
        connectedClients.setForeground(appOrange);
        connectedClients.setFont(setAppLabelFont(15));
        connectedClients.setModel(connectedClientsListModel);
        this.add(connectedClients);
        this.setBackground(appNavyBlueLight);
        this.add(new AppLabel(usersList, 15, appOrange));
        this.add(connectedClients);
    }
}
