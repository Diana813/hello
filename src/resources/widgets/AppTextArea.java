package resources.widgets;

import java.awt.Insets;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.AppDimensions.appMargin;
import static resources.styles.AppFonts.setAppLabelFont;

public class AppTextArea extends JTextArea {


    public AppTextArea(int rows, int columns, int fontSize) {
        this.setRows(rows);
        this.setColumns(columns);
        this.setFont(setAppLabelFont(fontSize));
        this.setForeground(appNavyBlue);
        this.setMargin(new Insets(appMargin, appMargin, appMargin, appMargin));
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    }

    public void setEnterKeyActionListener(AbstractAction enterAction) {
        InputMap inputMap = this.getInputMap(WHEN_FOCUSED);
        ActionMap actionMap = this.getActionMap();
        KeyStroke enterStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        inputMap.put(enterStroke, enterStroke.toString());
        actionMap.put(enterStroke.toString(), enterAction);
    }

}
