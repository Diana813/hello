package resources.styles;

import java.awt.Font;

/**
 * Klasa zbiorcza dla czcionek używanych w aplikacji
 */
public class AppFonts {

    /**
     * Metoda odpowiedzialna za utworzenie czcionki używanej w aplikacji
     * @param fontSize to wielkość czcionki
     * @return Font
     */
    public static Font setAppLabelFont(int fontSize){
        return new Font("Consolas", Font.ITALIC, fontSize);
    }
}
