package resources.layouts.panels;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static resources.styles.AppColours.transparent;

public class Panel extends JPanel {

    public Panel(){
        this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.setBackground(transparent);
    }

}
