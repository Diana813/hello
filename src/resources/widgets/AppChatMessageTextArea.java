package resources.widgets;

import java.awt.Dimension;
import javax.swing.plaf.basic.BasicBorders;
import static resources.strings.AppStrings.me;
import static resources.styles.AppColors.appNavyBlue;
import resources.styles.AppDimensions;
import static resources.styles.AppFonts.setAppLabelFont;

public class AppChatMessageTextArea extends AppTextArea {

    public AppChatMessageTextArea(int rows, int columns, int fontSize, String message) {
        super(rows, columns);
        this.setPreferredSize(new Dimension(AppDimensions.defaultChatWindowWidth - 30, 50));
        this.setFont(setAppLabelFont(fontSize));
        this.setText(message.replace(me, ""));
        this.setEditable(false);
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue, appNavyBlue, appNavyBlue, appNavyBlue));
    }

}
