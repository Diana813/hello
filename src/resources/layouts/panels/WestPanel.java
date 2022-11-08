package resources.layouts.panels;

import java.awt.Dimension;
import static resources.strings.AppStrings.usersList;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.AppColors.appOrange;
import static resources.styles.AppDimensions.eastPanelDim;
import resources.widgets.AppLabel;
import resources.widgets.AppUserList;

/**
 * Klasa WestPanel, rozszerzająca klasę Panel, jest kontenerem, w którym znajduje się lista aktualnie połączonych
 * użytkowników
 */
public class WestPanel extends Panel {

    private final AppUserList connectedUsers = new AppUserList();

    /**
     * Tworzy nowy obiekt klasy WestPanel
     */
    public WestPanel() {
        this.setPreferredSize(new Dimension(eastPanelDim, eastPanelDim));
        this.setBackground(appNavyBlue);
        this.add(new AppLabel(usersList, 15, appOrange));
        this.add(connectedUsers);
    }

    /**
     * Metoda odpowiedzialna za wyświeltanie kolejnych użytkowników połączonych z serwerem
     * @param newConnectedUser to imię połączonego użytkownika
     */
    public void displayConnectedUser(String newConnectedUser) {
        if (!connectedUsers.getModel().contains(newConnectedUser)) {
            connectedUsers.getModel().addElement(newConnectedUser);
        }
    }

    /**
     * Metoda odpowiedzialna za usuwanie z listy użytkownika, który opuścił konwersację
     * @param disconnectedUser to imię użytkownika opuszczającego konwersację
     */
    public void removeDisconnectedUserFromTheList(String disconnectedUser) {
        connectedUsers.getModel().removeElement(disconnectedUser);
    }
}
