package resources.layouts.panels;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import resources.layouts.UserInputLayout;
import static resources.styles.AppImages.send_icon;
import resources.widgets.AppScrollPane;
import resources.widgets.AppSubmitButton;
import resources.widgets.AppTextArea;

public class SouthPanel extends Panel {

    private final JTextArea textArea;
    private final NorthPanel northPanel;

    public SouthPanel(NorthPanel northPanel) {
        this.northPanel = northPanel;
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.textArea = new AppTextArea(30, 1);
        this.add(new UserInputLayout(addSubmitButton(), new AppScrollPane(0, 50, textArea)));
    }

    private JButton addSubmitButton() {
        JButton button = new AppSubmitButton(send_icon);
        button.addActionListener(e -> sendMessage());
        return button;
    }

    private void sendMessage() {
        String message = textArea.getText();
        if (!message.isEmpty()) {
            northPanel.getClient().sendMessage(textArea.getText());
            textArea.setText("");
        }
    }
}
