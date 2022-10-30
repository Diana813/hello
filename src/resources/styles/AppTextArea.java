package resources.styles;

import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;

import static resources.styles.AppColours.appNavyBlue;
import static resources.styles.AppFonts.textFieldFont;
import static resources.styles.Dimensions.appMargin;
import static resources.styles.Dimensions.defaultTextFieldHeight;
import static resources.styles.Dimensions.defaultTextFieldWidth;

public class AppTextArea extends JTextArea {

    public AppTextArea(int rows, int columns){
        this.setRows(rows);
        this.setColumns(columns);
        this.setPreferredSize(new Dimension(defaultTextFieldWidth, defaultTextFieldHeight));
        this.setFont(textFieldFont);
        this.setForeground(appNavyBlue);
        this.setMargin(new Insets(appMargin,appMargin,appMargin,appMargin));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    }
}
