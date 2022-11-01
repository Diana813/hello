package resources.layouts.panels;


import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import resources.layouts.UserInputLayout;
import static resources.styles.AppColours.appOrangeLight;
import static resources.styles.AppImages.send_icon;
import resources.widgets.AppTextArea;
import resources.widgets.SubmitButton;

public class SouthPanel extends Panel {

    private final JTextArea textArea;

    public SouthPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.textArea = new AppTextArea(30, 1);
        this.add(new UserInputLayout(addSubmitButton(), setScrollPane(textArea)));
    }

    private JScrollPane setScrollPane(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(0, 50));
        scrollPane.getVerticalScrollBar().setBackground(appOrangeLight);
        return scrollPane;
    }

    private JButton addSubmitButton() {
        JButton button = new SubmitButton(send_icon);
        button.addActionListener(e -> sendMessage());
        return button;
    }

    private void sendMessage() {
        System.out.println(textArea.getText());
        textArea.setText("");
    }
}
