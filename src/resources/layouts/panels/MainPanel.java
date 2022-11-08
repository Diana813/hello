package resources.layouts.panels;

import javax.swing.BoxLayout;
import resources.layouts.UserMessageLayout;
import static resources.strings.AppStrings.loginError;
import static resources.strings.AppStrings.userAdded;
import static resources.strings.AppStrings.userRemoved;
import static resources.styles.AppColors.appNavyBlue;
import resources.widgets.AppLabel;

/**
 * Klasa MainPanel, rozszerzająca klasę Panel, jest kontenerem, w którym wyświetlane są wiadomości wysyłane przez
 * użytkowników komunikatora.
 */
public class MainPanel extends Panel {

    /**
     * Tworzy nowy obiekt MainPanel.
     */
    public MainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    /**
     * Wyświetla otrzymane wiadomości w odpowiedni sposób. Używa innego widgetu dla informacji nadawanych przez serwer,
     * a innego do wyświetlania wiadomości od użytkownika.
     * @param message jest wiadomością tekstową otrzymaną przez użytkownika
     */
    public void displayMessage(String message) {
        if (isMessageFromServer(message)) {
            this.add(new AppLabel(message, 15, appNavyBlue));
        } else {
            UserMessageLayout label = new UserMessageLayout(message);
            label.setCorrectAlignment();
            this.add(label);
        }
        this.validate();
        this.repaint();
    }

    /**
     * Sprawdza, czy otrzymana wiadomość jest broadcastem wysyłanym przez serwer do wszystkich uczestników rozmowy
     * @param message jest wiadomością tekstową otrzymaną przez użytkownika
     * @return zwraca wartość true lub false
     */
    private boolean isMessageFromServer(String message) {
        return message.contains(userAdded) || message.contains(userRemoved) || message.contains(loginError);
    }

}
