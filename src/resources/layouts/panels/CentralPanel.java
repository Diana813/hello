package resources.layouts.panels;

import java.awt.Dimension;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.Dimensions.defaultChatWindowHeight;
import static resources.styles.Dimensions.defaultChatWindowWidth;
import resources.widgets.AppLabel;

public class CentralPanel extends Panel {
    public CentralPanel() {
        this.setPreferredSize(new Dimension(defaultChatWindowWidth, defaultChatWindowHeight));
    }

    public void displayMessage(String message) {
        AppLabel label = new AppLabel(message, 15, appNavyBlue);
        this.add(label);
    }
}
