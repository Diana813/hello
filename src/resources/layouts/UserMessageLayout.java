package resources.layouts;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import resources.layouts.panels.Panel;
import static resources.strings.AppStrings.me;
import resources.styles.AppDimensions;
import static resources.styles.AppImages.user_icon;
import resources.widgets.AppChatMessageTextArea;

public class UserMessageLayout extends Panel {

    private final String message;
    private final JLabel label;


    public UserMessageLayout(String message) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setPreferredSize(new Dimension(AppDimensions.defaultChatWindowWidth - 30, AppDimensions.defaultTextFieldHeight + 50));
        this.message = message;
        this.label = new JLabel(user_icon);

    }

    public void setCorrectAlignment() {
        Panel p = new Panel();
        if (!message.contains(me)) {
            p.add(label);
            p.add(new AppChatMessageTextArea(1, 1, 15, message));

        } else {
            p.add(new AppChatMessageTextArea(1, 1, 15, message.replace(me, "")));
            p.add(label);

        }
        p.setPreferredSize(new Dimension(AppDimensions.defaultChatWindowWidth, 50));
        this.add(p);
    }

}
