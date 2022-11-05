package resources.layouts.panels;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static resources.styles.AppColors.transparent;

public class Panel extends JPanel {

    public Panel() {
        this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.setOpaque(false);
        this.setBackground(transparent);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
