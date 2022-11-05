package resources.layouts.panels;

import javax.swing.BoxLayout;
import resources.layouts.UserMessageLayout;
import static resources.strings.AppStrings.loginError;
import static resources.strings.AppStrings.userAdded;
import static resources.strings.AppStrings.userRemoved;
import static resources.styles.AppColors.appNavyBlue;
import resources.widgets.AppLabel;

public class CentralPanel extends Panel {


    public CentralPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void displayMessage(String message) {
        if (isMessageFromServer(message)) {
            this.add(new AppLabel(message, 15, appNavyBlue));
        } else {
            UserMessageLayout label = new UserMessageLayout(message);
            label.setCorrectAlignment();
            this.add(label);
        }
        this.validate();
        this.repaint();
    }

    private boolean isMessageFromServer(String message) {
        return message.contains(userAdded) || message.contains(userRemoved) || message.contains(loginError);
    }

}
