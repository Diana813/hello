package resources.widgets;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static resources.styles.AppDimensions.appMargin;

/**
 * Klasa AppSubmitButton odpowiedzialna za wygląd przycisków w aplikacji
 */
public class AppSubmitButton extends JButton {

    /**
     * Tworzy nowy obiekt typu AppSubmitButton
     * @param buttonIcon ikona wyświetlana na przycisku
     */
    public AppSubmitButton(ImageIcon buttonIcon){
        this.setContentAreaFilled(true);
        this.setBackground(Color.white);
        this.setIcon(buttonIcon);
        this.setBorder(BorderFactory.createEmptyBorder(appMargin, appMargin, appMargin, appMargin));
        this.setFocusable(false);//removes the frame around text
    }

}
