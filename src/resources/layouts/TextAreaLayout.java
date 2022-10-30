package resources.layouts;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import static resources.styles.Dimensions.appMargin;

public class TextAreaLayout extends JPanel {

    public TextAreaLayout(JButton button, JScrollPane scrollPane) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new EmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.add(scrollPane);
        this.add(button);
    }

    public TextAreaLayout(JTextArea textArea, JButton button) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new EmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.add(textArea);
        this.add(button);
    }

}
