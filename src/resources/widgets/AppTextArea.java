package resources.widgets;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import static resources.styles.AppColours.appNavyBlue;
import static resources.styles.AppFonts.setAppLabelFont;
import static resources.styles.Dimensions.appMargin;
import static resources.styles.Dimensions.defaultTextFieldHeight;
import static resources.styles.Dimensions.defaultTextFieldWidth;

public class AppTextArea extends JTextArea {

    public AppTextArea(int rows, int columns){
        this.setRows(rows);
        this.setColumns(columns);
        this.setPreferredSize(new Dimension(defaultTextFieldWidth, defaultTextFieldHeight));
        this.setFont(setAppLabelFont(20));
        this.setForeground(appNavyBlue);
        this.setMargin(new Insets(appMargin,appMargin,appMargin,appMargin));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    }
}
