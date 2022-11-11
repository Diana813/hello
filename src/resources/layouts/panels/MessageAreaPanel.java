package resources.layouts.panels;


import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import resources.layouts.UserInputLayout;
import static resources.strings.AppStrings.loginError;
import static resources.styles.AppImages.send_icon;
import resources.widgets.AppScrollPane;
import resources.widgets.AppSubmitButton;
import resources.widgets.AppTextArea;

/**
 * Klasa MessageAreaPanel, rozszerzająca klasę Panel, jest kontenerem, w którym znajduje się część
 * interfejsu odpowiadająca za pisanie i wysyłanie wiadomości przez użytkownika
 */
public class MessageAreaPanel extends Panel {

    private final AppTextArea textArea;
    private final UserAreaPanel userAreaPanel;
    private final MainPanel mainPanel;

    /**
     * Tworzy nowy obiekt klasy MessageAreaPanel
     *
     * @param userAreaPanel jest kontenerem, w którym użytkownik wpisuje swoje dane i łączy
     *                      się z serwerem
     * @param mainPanel     jest kontenerem, w którym wyświetlane są wiadomości od użytkownika
     */
    public MessageAreaPanel(UserAreaPanel userAreaPanel, MainPanel mainPanel) {
        this.userAreaPanel = userAreaPanel;
        this.mainPanel = mainPanel;
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.textArea = new AppTextArea(1, 1, 15);
        textArea.setEnterKeyActionListener(setEnterAction());
        this.add(new UserInputLayout(addSubmitButton(), new AppScrollPane(textArea)));
    }

    /**
     * Metoda odpowiadająca za pobieranie wiadomości z pola tekstowego i wysyłanie jej, oraz za obsługę błędu
     * polegającego na wysyłaniu wiadomości przez osobę niepołączoną z serwerem
     */
    private void sendMessage() {
        String message = textArea.getText();
        if (userAreaPanel.getClient() == null) {
            mainPanel.displayMessage(loginError);
        } else if (!message.isEmpty()) {
            userAreaPanel.getClient().sendMessage(textArea.getText());
            textArea.setText("");
        }
    }

    /**
     * Metoda odpowiedzialna za utworzenie przycisku, będącego obiektem klasy AppSubmitButton i nadanie mu funkcji
     * wywoływania metody sendMessage()
     *
     * @return obiekt klasy JButton
     */
    private JButton addSubmitButton() {
        JButton button = new AppSubmitButton(send_icon);
        button.addActionListener(e -> sendMessage());
        return button;
    }

    /**
     * Metoda odpowiedzialna na wywoływanie metody sendMessage() po kliknięciu przycisku Enter
     *
     * @return AbstractAction
     */
    private AbstractAction setEnterAction() {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                sendMessage();
            }
        };
    }

}
