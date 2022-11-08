package resources.layouts;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import resources.layouts.panels.EastPanel;
import resources.layouts.panels.WestPanel;
import static resources.strings.AppStrings.appTitle;
import static resources.styles.AppImages.logo;
import resources.widgets.AppBackground;

/**
 * Klasa ChatLayout, rozszerzająca klasę JFrame, tworzy okno aplikacji
 */
public class ChatLayout extends JFrame {

    /**
     * Tworzy nowy obiekt klasy ChatLayout
     */
    public ChatLayout() {
        this.setTitle(appTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.setContentPane(new AppBackground());
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        WestPanel westPanel = new WestPanel();
        this.add(westPanel);
        this.add(new EastPanel(westPanel));
        this.pack();
        this.setVisible(true);
    }

}
