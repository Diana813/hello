package resources.layouts.panels;

import client.Client;
import java.awt.BorderLayout;
import static resources.styles.AppDimensions.defaultChatWindowHeight;
import resources.widgets.AppScrollPane;

/**
 * Klasa bedąca kontenerem dla wszystkich komponentów aplikacji z wyłaczeniem komponentu
 * zawierającego listę zalogowanych użytkowników.
 */
public class EastPanel extends Panel {

    /**
     * Tworzy nowy obiet EastPanel
     * @param westPanel jest kontenerem zawierającym listę użytkowników
     */
    public EastPanel(WestPanel westPanel) {
        this.setLayout(new BorderLayout());
        MainPanel mainPanel = new MainPanel();
        UserAreaPanel userAreaPanel = new UserAreaPanel(westPanel, mainPanel);
        Client client = userAreaPanel.getClient();
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(userAreaPanel, BorderLayout.NORTH);
        this.add(new MessageAreaPanel(client, mainPanel), BorderLayout.SOUTH);
        this.add(new AppScrollPane(0, defaultChatWindowHeight, mainPanel));
    }
}
