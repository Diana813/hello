package resources.layouts;

import resources.layouts.panels.CentralPanel;
import resources.layouts.panels.EastPanel;
import resources.layouts.panels.NorthPanel;
import resources.layouts.panels.SouthPanel;
import resources.layouts.panels.WestPanel;
import resources.styles.AppBackground;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import static resources.styles.AppImages.logo;
import static resources.styles.Dimensions.defaultChatWindowHeight;
import static resources.styles.Dimensions.defaultChatWindowWidth;
import static resources.strings.AppStrings.appTitle;

public class ChatLayout extends JFrame {

    public ChatLayout() {
        this.setTitle(appTitle);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(defaultChatWindowWidth, defaultChatWindowHeight);
        this.setIconImage(logo.getImage());
        this.setContentPane(new AppBackground());
        this.setLayout(new BorderLayout());
        this.add(new EastPanel(), BorderLayout.EAST);
        this.add(new NorthPanel(), BorderLayout.NORTH);
        this.add(new SouthPanel(), BorderLayout.SOUTH);
        this.add(new WestPanel(), BorderLayout.WEST);
        this.add(new CentralPanel(), BorderLayout.CENTER);
        this.setVisible(true);
    }


}
