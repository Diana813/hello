package resources.layouts.panels;

import client.Client;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import resources.layouts.UserInputLayout;
import static resources.strings.AppStrings.anonymousUser;
import static resources.strings.AppStrings.enterYourNickname;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.AppDimensions.textAreaDimension;
import static resources.styles.AppImages.enter_icon;
import resources.widgets.AppLabel;
import resources.widgets.AppSubmitButton;
import resources.widgets.AppTextArea;

/**
 * Klasa UserAreaPanel jest kontenerem dla fragmentu interfejsu odpowiadającego za dodawanie nowego użytkownika
 */
public class UserAreaPanel extends Panel {

    private final AppTextArea textArea;
    private final JButton button;
    private String username;
    private final WestPanel westPanel;
    private final MainPanel mainPanel;
    private Client client;


    /**
     * Tworzy nowy obiekt UserAreaPanel
     * @param westPanel jest kontenerem zawierającym listę zalogowanych użytkowników
     * @param mainPanel jest kontenerem, w którym wyświetlane są wiadomości
     */
    public UserAreaPanel(WestPanel westPanel, MainPanel mainPanel) {
        this.westPanel = westPanel;
        this.mainPanel = mainPanel;
        this.setLayout(new GridLayout(2, 1));
        this.add(new AppLabel(enterYourNickname, 20, appNavyBlue));
        this.button = addSubmissionButton();
        this.textArea = new AppTextArea(1, 1, 20);
        textArea.setPreferredSize(textAreaDimension);
        textArea.setEnterKeyActionListener(setEnterAction());
        this.add(new UserInputLayout(textArea, button));
    }

    /**
     * Metoda pobierająca utworzonego użytkownika
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Metoda odpowiadająca za pobranie nazwy użytkownika z pola tekstowego, wyłączenie możliwości edycji tego pola
     * i deaktywację przycisku służącego do zatwierdzenia wpisanych informacji
     */
    private void getUserNameAndDisableButton() {
        String nickname = textArea.getText();
        username = nickname.isEmpty() ? anonymousUser : nickname;
        textArea.setText("");
        textArea.append(username);
        textArea.setEnabled(false);
        button.setEnabled(false);
    }

    /**
     * Metoda odpowiadająca za pobranie danych użytkownika i połączenie go z serwerem
     */
    private void getNicknameAndConnectUser() {
        getUserNameAndDisableButton();
        this.client = new Client(westPanel, mainPanel);
        client.getMessagesFromOtherUsers();
        client.sendMessage(username);
    }

    /**
     * Metoda tworząca nowy obiekt klasy AppSubmitButton i nadająca mu funkcję wywoływania metody getNicknameAndConnectUser()
     * @return AppSubmitButton
     */
    private AppSubmitButton addSubmissionButton() {
        AppSubmitButton button = new AppSubmitButton(enter_icon);
        button.addActionListener(e -> getNicknameAndConnectUser());
        return button;
    }

    /**
     * Metoda odpowiadająca za wywoływanie metody getNicknameAndConnectUser() po kliknięciu przycisku Enter
     * @return AbstractAction
     */
    private AbstractAction setEnterAction() {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                getNicknameAndConnectUser();
            }
        };
    }


}
