package resources.layouts;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import resources.layouts.panels.Panel;
import static resources.styles.AppColours.appNavyBlue;
import static resources.styles.Dimensions.appMargin;

public class UserInputLayout extends Panel {

    public UserInputLayout(JButton button, JScrollPane scrollPane) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new EmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue, appNavyBlue, appNavyBlue, appNavyBlue));
        this.add(scrollPane);
        this.add(button);
    }

    public UserInputLayout(JTextArea textArea, JButton button) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new EmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue,appNavyBlue, appNavyBlue, appNavyBlue));
        this.add(textArea);
        this.add(button);
    }

}
