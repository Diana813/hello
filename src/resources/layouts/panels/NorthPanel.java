package resources.layouts.panels;

import client.Client;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import resources.layouts.UserInputLayout;
import static resources.strings.AppStrings.anonymousUser;
import static resources.strings.AppStrings.enterYourNickname;
import static resources.styles.AppColours.appNavyBlue;
import static resources.styles.AppImages.enter_icon;
import resources.widgets.AppLabel;
import resources.widgets.AppTextArea;
import resources.widgets.SubmitButton;

public class NorthPanel extends Panel {

    private final JTextArea textArea;
    private final JButton button;
    private String username;

    public NorthPanel() {
        this.setLayout(new GridLayout(2, 1));
        this.add(new AppLabel(enterYourNickname, 20, appNavyBlue));
        this.button = addSubmissionButton();
        this.textArea = new AppTextArea(1, 1);
        this.add(new UserInputLayout(textArea, button));
    }

    private void getUserNameAndDisableButton() {
        String nickname = textArea.getText();
        username = nickname.isEmpty() ? anonymousUser : nickname;
        textArea.setText("");
        textArea.append(username);
        textArea.setEnabled(false);
        button.setEnabled(false);
    }

    private void getNicknameAndConnectUser() {
        getUserNameAndDisableButton();
        Client client = new Client();
        client.getMessagesFromOtherUsers();
        client.sendMessage(username);
    }

    private SubmitButton addSubmissionButton() {
        SubmitButton button = new SubmitButton(enter_icon);
        button.addActionListener(e -> getNicknameAndConnectUser());
        return button;
    }

}
