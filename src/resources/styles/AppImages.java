package resources.styles;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class AppImages {

    public static final ImageIcon logo = new ImageIcon("images/hello.png");

    public static final ImageIcon send_icon = new ImageIcon("images/send_icon.png");

    public static final ImageIcon enter_icon = new ImageIcon("images/enter.png");

    public static Image getBackgroundImage() {
        return Toolkit.getDefaultToolkit().createImage("images/chatAppBackground.png");
    }

}
