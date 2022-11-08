package resources.widgets;

import java.awt.Dimension;
import javax.swing.plaf.basic.BasicBorders;
import static resources.strings.AppStrings.me;
import static resources.styles.AppColors.appNavyBlue;
import resources.styles.AppDimensions;

/**
 * Klasa AppChatMessageTextArea, rozszerzająca klasę AppTextArea, do wyświetlania wiadomości od użytkowników w głównym
 * oknie aplikacji
 */
public class AppChatMessageTextArea extends AppTextArea {

    /**
     * Tworzy nowy obiekt AppChatMessageextArea
     * @param message to wiadomość do wyświetlenia w polu tekstowym
     * @param numberOfRows to ilość wierszy do wyświetlenia w polu tekstowym
     */
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
