package resources.layouts.panels;

import org.w3c.dom.Text;

import javax.swing.JPanel;

import static resources.styles.AppColours.transparent;

public class CentralPanel extends JPanel {
    private Text text;
    private NorthPanel northPanel;

    public CentralPanel(){
        this.setBackground(transparent);
    }
}
