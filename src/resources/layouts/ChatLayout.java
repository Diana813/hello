package resources.layouts;

import javax.swing.*;
import resources.layouts.panels.CentralPanel;
import resources.layouts.panels.EastPanel;
import resources.layouts.panels.NorthPanel;
import resources.layouts.panels.SouthPanel;
import resources.layouts.panels.WestPanel;
import resources.widgets.AppBackground;

import java.awt.BorderLayout;

import static resources.styles.AppImages.logo;
import static resources.styles.Dimensions.defaultChatWindowHeight;
import static resources.styles.Dimensions.defaultChatWindowWidth;
import static resources.strings.AppStrings.appTitle;

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
        this.setVisible(true);
    }


}
