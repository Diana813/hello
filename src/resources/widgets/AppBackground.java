package resources.widgets;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import static resources.styles.AppImages.getBackgroundImage;

public class AppBackground extends JPanel {
    private final Image backgroundImage;

    public AppBackground() {
        this.backgroundImage = getBackgroundImage();

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }



}