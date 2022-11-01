package resources.widgets;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import static resources.styles.AppFonts.setAppLabelFont;
import static resources.styles.Dimensions.appMargin;

public class AppLabel extends JLabel {

    public AppLabel(String labelText, int fontSize, Color textColor){
        this.setText(labelText);
        this.setFont(setAppLabelFont(fontSize));
        this.setForeground(textColor);
        this.setBorder(BorderFactory.createEmptyBorder(appMargin, appMargin, appMargin, appMargin));
    }
}
