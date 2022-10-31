package resources.layouts.panels;

import client.Client;
import java.awt.*;
import javax.swing.*;
import resources.layouts.UserInputLayout;
import resources.strings.AppStrings;
import static resources.strings.AppStrings.enterYourNickname;
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
        this.add(new AppLabel(enterYourNickname, 20));
        this.button = addSubmissionButton();
        this.textArea = new AppTextArea(1, 1);
        this.add(new UserInputLayout(textArea, button));
    }

    private void getUserName() {
        this.username = textArea.getText();
        Client client = new Client(username);
        client.getMessagesFromOtherUsers();
        client.sendMessage();
    }

    private SubmitButton addSubmissionButton() {
        SubmitButton button = new SubmitButton(enter_icon);
        button.addActionListener(e -> getUserName());
        return button;
    }

    public String setUserInfo() {
        return username != null ? AppStrings.userConnected(username) : null;
    }
}
