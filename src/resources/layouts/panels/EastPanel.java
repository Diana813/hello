package resources.layouts.panels;

import java.awt.BorderLayout;
import static resources.styles.AppDimensions.defaultChatWindowHeight;
import resources.widgets.AppScrollPane;

public class EastPanel extends Panel {

    public EastPanel(WestPanel westPanel) {
        this.setLayout(new BorderLayout());
        CentralPanel centralPanel = new CentralPanel();
        NorthPanel northPanel = new NorthPanel(westPanel, centralPanel);
        this.add(centralPanel, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(new SouthPanel(northPanel), BorderLayout.SOUTH);
        this.add(new AppScrollPane(0, defaultChatWindowHeight, centralPanel));
    }
}
