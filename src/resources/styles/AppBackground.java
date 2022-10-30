package resources.styles;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static resources.styles.AppImages.getBackgroundImage;
import static resources.styles.Dimensions.appMargin;

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