package resources.layouts.panels;

import client.Client;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import resources.layouts.UserInputLayout;
import static resources.strings.AppStrings.anonymousUser;
import static resources.strings.AppStrings.enterYourNickname;
import static resources.styles.AppColors.appNavyBlue;
import resources.styles.AppDimensions;
import static resources.styles.AppDimensions.textAreaDimension;
import static resources.styles.AppImages.enter_icon;
import resources.widgets.AppLabel;
import resources.widgets.AppTextArea;
import resources.widgets.AppSubmitButton;

public class NorthPanel extends Panel {

    private final JTextArea textArea;
    private final JButton button;
    private String username;
    private final WestPanel westPanel;
    private final CentralPanel centralPanel;
    private Client client;


    public NorthPanel(WestPanel westPanel, CentralPanel centralPanel) {
        this.westPanel = westPanel;
        this.centralPanel = centralPanel;
        this.setLayout(new GridLayout(2, 1));
        this.add(new AppLabel(enterYourNickname, 20, appNavyBlue));
        this.button = addSubmissionButton();
        this.textArea = new AppTextArea(1, 1, 20);
        textArea.setPreferredSize(textAreaDimension);
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
        this.client = new Client(westPanel, centralPanel);
        client.getMessagesFromOtherUsers();
        client.sendMessage(username);
    }

    private AppSubmitButton addSubmissionButton() {
        AppSubmitButton button = new AppSubmitButton(enter_icon);
        button.addActionListener(e -> getNicknameAndConnectUser());
        return button;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
