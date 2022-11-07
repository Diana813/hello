package resources.layouts.panels;


import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import resources.layouts.UserInputLayout;
import static resources.strings.AppStrings.loginError;
import static resources.styles.AppDimensions.textAreaDimension;
import static resources.styles.AppImages.send_icon;
import resources.widgets.AppScrollPane;
import resources.widgets.AppSubmitButton;
import resources.widgets.AppTextArea;

public class SouthPanel extends Panel {

    private final AppTextArea textArea;
    private final NorthPanel northPanel;
    private final CentralPanel centralPanel;

    public SouthPanel(NorthPanel northPanel, CentralPanel centralPanel) {
        this.northPanel = northPanel;
        this.centralPanel = centralPanel;
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.textArea = new AppTextArea(30, 1, 15);
        textArea.setPreferredSize(textAreaDimension);
        textArea.setEnterKeyActionListener(setEnterAction());
        this.add(new UserInputLayout(addSubmitButton(), new AppScrollPane(0, 50, textArea)));
    }

    private JButton addSubmitButton() {
        JButton button = new AppSubmitButton(send_icon);
        button.addActionListener(e -> sendMessage());
        return button;
    }

    private void sendMessage() {
        String message = textArea.getText();
        if (northPanel.getClient() == null) {
            centralPanel.displayMessage(loginError);
        } else if (!message.isEmpty()) {
            northPanel.getClient().sendMessage(textArea.getText());
            textArea.setText("");
        }
    }

    private AbstractAction setEnterAction() {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                sendMessage();
            }
        };
    }

}
