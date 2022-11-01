package resources.widgets;

import java.awt.Graphics;
import java.awt.Image;
import resources.layouts.panels.Panel;
import static resources.styles.AppImages.getBackgroundImage;

public class AppBackground extends Panel {
    private final Image backgroundImage;

    public AppBackground() {
        this.backgroundImage = getBackgroundImage();

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

}