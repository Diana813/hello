package resources.widgets;

import java.awt.Dimension;
import javax.swing.plaf.basic.BasicBorders;
import static resources.strings.AppStrings.me;
import static resources.styles.AppColors.appNavyBlue;
import resources.styles.AppDimensions;

public class AppChatMessageTextArea extends AppTextArea {

    public AppChatMessageTextArea(String message, int numberOfRows) {
        super(1, 1, 15);
        this.setPreferredSize(new Dimension(AppDimensions.defaultChatWindowWidth - 40, numberOfRows * 25));
        this.setMaximumSize(new Dimension(2000, numberOfRows * 25));
        this.setText(message.replace(me, ""));
        this.setEditable(false);
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue, appNavyBlue, appNavyBlue, appNavyBlue));
        this.setAlignmentY(CENTER_ALIGNMENT);
    }

}
