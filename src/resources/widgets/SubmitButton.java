package resources.widgets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import resources.styles.AppColours;
import static resources.styles.Dimensions.appMargin;

public class SubmitButton extends JButton {

    public SubmitButton(ImageIcon buttonIcon){
        this.setIcon(buttonIcon);
        this.setBorder(BorderFactory.createEmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.setContentAreaFilled(false);//button background color
        this.setFocusable(false);//removes the frame around text
    }
}
