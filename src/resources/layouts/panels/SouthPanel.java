package resources.layouts.panels;


import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import resources.layouts.UserInputLayout;
import static resources.strings.AppStrings.loginError;
import static resources.styles.AppDimensions.textAreaDimension;
import resources.styles.AppFonts;
import static resources.styles.AppImages.send_icon;
import resources.widgets.AppScrollPane;
import resources.widgets.AppSubmitButton;
import resources.widgets.AppTextArea;

public class SouthPanel extends Panel {

    private final JTextArea textArea;
    private final NorthPanel northPanel;
    private final CentralPanel centralPanel;

    public SouthPanel(NorthPanel northPanel, CentralPanel centralPanel) {
        this.northPanel = northPanel;
        this.centralPanel = centralPanel;
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.textArea = new AppTextArea(30, 1, 15);
        textArea.setPreferredSize(textAreaDimension);
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

}
