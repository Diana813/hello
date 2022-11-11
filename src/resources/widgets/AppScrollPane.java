package resources.widgets;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import static resources.styles.AppColors.appNavyBlue;

/**
 * Klasa AppScrollPane, dziedzicząca po klasie JScrollPane, odpowiedzialna za wygląd suwaków w aplikacji
 */
public class AppScrollPane extends JScrollPane {

    /**
     * Tworzy nowy obiekt typu AppScrollPane
     * @param component komponent objęty obszarem skrolowania
     */
    public AppScrollPane(JComponent component) {
        super(component);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getVerticalScrollBar().setBackground(appNavyBlue);
        this.setAutoscrolls(true);
        this.getViewport().setOpaque(false);
        this.setOpaque(false);
        this.setBackground(appNavyBlue);
    }
}
