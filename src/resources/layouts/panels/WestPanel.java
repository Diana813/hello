package resources.layouts.panels;

import java.awt.Dimension;
import static resources.strings.AppStrings.usersList;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.AppColors.appOrange;
import static resources.styles.AppDimensions.eastPanelDim;
import resources.widgets.AppLabel;
import resources.widgets.AppUserList;


public class WestPanel extends Panel {

    private final AppUserList connectedUsers = new AppUserList();

    public WestPanel() {
        this.setPreferredSize(new Dimension(eastPanelDim, eastPanelDim));
        this.setBackground(appNavyBlue);
        this.add(new AppLabel(usersList, 15, appOrange));
        this.add(connectedUsers);
    }

    public void displayConnectedUser(String newConnectedUser) {
        if (!connectedUsers.getModel().contains(newConnectedUser)) {
            connectedUsers.getModel().addElement(newConnectedUser);
        }
    }

    public void removeDisconnectedUserFromTheList(String disconnectedUser) {
        connectedUsers.getModel().removeElement(disconnectedUser);
    }
}
