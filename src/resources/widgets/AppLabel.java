package resources.widgets;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import static resources.styles.AppFonts.setAppLabelFont;
import static resources.styles.AppDimensions.appMargin;

/**
 * Klasa AppLabel dziedzicząca po klasie JLabel, odpowiedzialna za wygląd wyświetlanych w aplikacji etykiet
 */
public class AppLabel extends JLabel {

    /**
     * Tworzy nowy obiekt AppLabel
     * @param labelText tekst wyświetlany na etykiecie
     * @param fontSize wielkość czcionki
     * @param textColor kolor tekstu
     */
    public AppLabel(String labelText, int fontSize, Color textColor){
        this.setText(labelText);
        this.setFont(setAppLabelFont(fontSize));
        this.setForeground(textColor);
        this.setBorder(BorderFactory.createEmptyBorder(appMargin, appMargin, appMargin, appMargin));
    }
}
