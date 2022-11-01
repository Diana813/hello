package resources.widgets;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import static resources.styles.AppColors.appOrange;
import static resources.styles.AppColors.transparent;
import static resources.styles.AppFonts.setAppLabelFont;

public class AppUserList extends JList<String> {
    private final DefaultListModel<String> model;

    public AppUserList(){
        this.model = new DefaultListModel<>();
        this.setBackground(transparent);
        this.setForeground(appOrange);
        this.setFont(setAppLabelFont(15));
        this.setModel(model);
    }

    @Override
    public DefaultListModel<String> getModel() {
        return model;
    }
}
