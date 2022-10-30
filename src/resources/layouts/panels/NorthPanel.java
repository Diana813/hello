package resources.layouts.panels;

import client.Client;
import resources.layouts.TextAreaLayout;
import resources.strings.AppStrings;
import resources.styles.AppColours;
import resources.styles.AppTextArea;
import resources.styles.SubmitButton;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;

import static client.ClientHandler.connectedClients;
import static resources.styles.AppColours.appNavyBlue;
import static resources.styles.AppColours.appOrange;
import static resources.styles.AppFonts.textFieldFont;
import static resources.styles.AppImages.enter_icon;
import static resources.styles.Dimensions.appMargin;
import static resources.strings.AppStrings.enterYourNickname;

public class NorthPanel extends JPanel {

    private final JTextArea textArea;
    private final JButton button;
    private String username;

    public NorthPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(addNicknameLabel());
        button = new SubmitButton(enter_icon);
        button.setVisible(true);
        button.addActionListener(e -> getUserName());
        this.textArea = new AppTextArea(1, 1);
        this.add(new TextAreaLayout(textArea, button));
    }

    private void getUserName() {
        this.username = textArea.getText();
        Client client = new Client(username);
        client.getMessagesFromOtherUsers();
        client.sendMessage();
    }



    private JLabel addNicknameLabel() {
        JLabel enterNicknameLabel = new JLabel();
        enterNicknameLabel.setText(enterYourNickname);
        enterNicknameLabel.setFont(textFieldFont);
        enterNicknameLabel.setForeground(appNavyBlue);
        enterNicknameLabel.setBorder(BorderFactory.createEmptyBorder(appMargin, appMargin, appMargin, appMargin));
        return enterNicknameLabel;
    }

    public String setUserInfo(){
        return username != null ? AppStrings.userConnected(username) : null;
    }
}
