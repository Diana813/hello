package resources.widgets;

import java.awt.Graphics;
import java.awt.Image;
import resources.layouts.panels.Panel;
import static resources.styles.AppImages.getBackgroundImage;

/**
 * Klasa AppBackground, rozszerzająca klasę Panel, której zadaniem jest wyświetlanie obrazu jako tła aplikacji
 */
public class AppBackground extends Panel {
    private final Image backgroundImage;

    /**
     * Tworzy nowy obiekt AppBackground
     */
    public AppBackground() {
        this.backgroundImage = getBackgroundImage();

    }

    /**
     * Nadpisuje metodę paintComponent w celu wyświetlenia tła aplikacji
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}