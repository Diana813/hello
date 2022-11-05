package resources.layouts;

import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import resources.layouts.panels.WestPanel;
import resources.layouts.panels.EastPanel;
import static resources.strings.AppStrings.appTitle;
import static resources.styles.AppImages.logo;
import resources.widgets.AppBackground;

public class ChatLayout extends JFrame {

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
