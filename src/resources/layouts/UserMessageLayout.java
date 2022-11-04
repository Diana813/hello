package resources.layouts;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import resources.layouts.panels.Panel;
import static resources.strings.AppStrings.me;
import static resources.styles.AppDimensions.messageLayoutDimension;
import static resources.styles.AppImages.user_icon;
import resources.widgets.AppChatMessageTextArea;

public class UserMessageLayout extends Panel {

    private final String message;
    private final JLabel label;


    public UserMessageLayout(String message) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setPreferredSize(messageLayoutDimension);
        this.message = message;
        this.label = new JLabel(user_icon);

    }

    public void setCorrectAlignment() {
        if (!message.contains(me)) {
            this.add(label);
            this.add(new AppChatMessageTextArea(message));

        } else {
            this.add(new AppChatMessageTextArea(message));
            this.add(label);

        }
    }

}
