package resources.widgets;

import javax.swing.plaf.basic.BasicBorders;
import static resources.strings.AppStrings.me;
import static resources.styles.AppColors.appNavyBlue;
import static resources.styles.AppDimensions.messageTextAreaDimension;

public class AppChatMessageTextArea extends AppTextArea {

    public AppChatMessageTextArea(String message) {
        super(1, 1, 15, messageTextAreaDimension);
        this.setText(message.replace(me, ""));
        this.setEditable(false);
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue, appNavyBlue, appNavyBlue, appNavyBlue));
    }

}
