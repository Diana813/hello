package resources.layouts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import resources.layouts.panels.Panel;
import resources.styles.AppColours;
import static resources.styles.Dimensions.appMargin;

public class UserInputLayout extends Panel {

    public UserInputLayout(JButton button, JScrollPane scrollPane) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new EmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.add(scrollPane);
        this.add(button);
    }

    public UserInputLayout(JTextArea textArea, JButton button) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new EmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.add(textArea);
        this.add(button);
    }

}
