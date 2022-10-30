package resources.layouts.panels;


import resources.layouts.TextAreaLayout;
import resources.styles.AppTextArea;
import resources.styles.SubmitButton;

import javax.swing.*;
import java.awt.*;

import static resources.styles.AppImages.send_icon;

public class SouthPanel extends JPanel {

    private final JTextArea textArea;

    public SouthPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        JButton button = new SubmitButton(send_icon);
        button.addActionListener(e -> sendMessage());
        this.textArea = new AppTextArea(30, 1);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(15, 80));
        TextAreaLayout textAreaLayout = new TextAreaLayout(button, scrollPane);
        this.add(textAreaLayout);
    }

    private void sendMessage() {
        System.out.println(textArea.getText());
        textArea.setText("");
    }
}
