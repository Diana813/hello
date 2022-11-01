package resources.layouts.panels;

import java.awt.BorderLayout;

public class EastPanel extends Panel {

    public EastPanel(WestPanel westPanel) {
        this.setLayout(new BorderLayout());
        CentralPanel centralPanel = new CentralPanel();
        this.add(centralPanel, BorderLayout.CENTER);
        this.add(new NorthPanel(westPanel, centralPanel), BorderLayout.NORTH);
        this.add(new SouthPanel(), BorderLayout.SOUTH);
    }
}
