package resources.layouts;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import resources.layouts.panels.EastPanel;
import resources.layouts.panels.WestPanel;
import static resources.strings.AppStrings.appTitle;
import static resources.styles.AppImages.logo;
import resources.widgets.AppBackground;

public class ChatLayout extends JFrame {

    public ChatLayout() {
        this.setTitle(appTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(logo.getImage());
        this.setContentPane(new AppBackground());
        this.setLayout(new BorderLayout());
        this.add(new EastPanel(), BorderLayout.CENTER);
        this.add(new WestPanel(), BorderLayout.WEST);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }


}
