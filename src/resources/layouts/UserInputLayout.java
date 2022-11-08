package resources.layouts;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicBorders;
import resources.layouts.panels.Panel;
import static resources.styles.AppColors.appNavyBlue;

/**
 * Klasa UserInputLayout to klasa będąca kontenerem dla wszytskich fragmentów interfejsu przyjmujących dane wejściowe
 * od użytkownika
 */
public class UserInputLayout extends Panel {

    /**
     * Tworzy nowy obiekt UserInputLayout z suwakiem pozwalającym na wpisywanie długich wiadomości tekstowych
     * @param button to przycisk zatwierdzający wpisane przez użytkownika dane
     * @param scrollPane to suwak pozwalający na przesuwanie zawartości w obrębie pola tekstowegp
     */
    public UserInputLayout(JButton button, JScrollPane scrollPane) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue, appNavyBlue, appNavyBlue, appNavyBlue));
        this.add(scrollPane);
        this.add(button);
    }

    /**
     * Tworzy nowy obiekt UserInputLayout
     * @param textArea to pole tekstowe
     * @param button to przycisk zatwierdzający wpisane przez użytkownika dane
     */
    public UserInputLayout(JTextArea textArea, JButton button) {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setBorder(new BasicBorders.FieldBorder(appNavyBlue,appNavyBlue, appNavyBlue, appNavyBlue));
        this.add(textArea);
        this.add(button);
    }

}
