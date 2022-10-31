package resources.layouts.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;

public class WestPanel extends Panel{

    public WestPanel(){
        this.setLayout(new BorderLayout());
        this.add(new NorthPanel(), BorderLayout.NORTH);
        this.add(new CentralPanel(), BorderLayout.CENTER);
        this.add(new SouthPanel(), BorderLayout.SOUTH);
    }
}
