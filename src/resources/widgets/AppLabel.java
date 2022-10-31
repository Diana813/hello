package resources.widgets;

import javax.swing.*;
import static resources.styles.AppColours.appNavyBlue;
import static resources.styles.AppFonts.setAppLabelFont;
import static resources.styles.Dimensions.appMargin;

public class AppLabel extends JLabel {

    public AppLabel(String labelText, int fontSize){
        this.setText(labelText);
        this.setFont(setAppLabelFont(fontSize));
        this.setForeground(appNavyBlue);
        this.setBorder(BorderFactory.createEmptyBorder(appMargin, appMargin, appMargin, appMargin));
    }
}
