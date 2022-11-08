package resources.widgets;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import static resources.styles.AppColors.appOrange;
import static resources.styles.AppColors.transparent;
import static resources.styles.AppFonts.setAppLabelFont;

/**
 * Klasa AppUserList, dziedzicząca po klasie JList, odpowiada za wygląd listy połączonych użytkowników
 */
public class AppUserList extends JList<String> {
    private final DefaultListModel<String> model;

    /**
     * Tworzy nowy obiekt klasy AppUserList
     */
    public AppUserList(){
        this.model = new DefaultListModel<>();
        this.setBackground(transparent);
        this.setForeground(appOrange);
        this.setFont(setAppLabelFont(15));
        this.setModel(model);
    }

    /**
     * Getter do pobierania obiektu DefaultListModel
     * @return DefaultListModel
     */
    @Override
    public DefaultListModel<String> getModel() {
        return model;
    }
}
