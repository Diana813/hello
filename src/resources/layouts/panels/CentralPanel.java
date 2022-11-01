package resources.layouts.panels;

import java.awt.Dimension;
import org.w3c.dom.Text;
import static resources.styles.Dimensions.defaultChatWindowHeight;
import static resources.styles.Dimensions.defaultChatWindowWidth;

public class CentralPanel extends Panel {
    private Text text;
    private NorthPanel northPanel;

    public CentralPanel(){
        this.setPreferredSize(new Dimension(defaultChatWindowWidth, defaultChatWindowHeight));
    }

}
