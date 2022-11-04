package resources.widgets;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JTextArea;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.AppDimensions.appMargin;
import static resources.styles.AppDimensions.defaultTextFieldWidth;
import static resources.styles.AppFonts.setAppLabelFont;

public class AppTextArea extends JTextArea {

    public AppTextArea(int rows, int columns){
        this.setRows(rows);
        this.setColumns(columns);
        this.setPreferredSize(new Dimension(defaultTextFieldWidth, 0));
        this.setFont(setAppLabelFont(20));
        this.setForeground(appNavyBlue);
        this.setMargin(new Insets(appMargin,appMargin,appMargin,appMargin));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    }
}
