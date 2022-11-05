package resources.widgets;

import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import static resources.styles.AppColors.appOrangeLight;

public class AppScrollPane extends JScrollPane {

    public AppScrollPane(int width, int height, JComponent component) {
        super(component);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setPreferredSize(new Dimension(width, height));
        this.getVerticalScrollBar().setBackground(appOrangeLight);
        this.setAutoscrolls(true);
        this.getViewport().setOpaque(false);
        this.setOpaque(false);
        this.setBackground(appOrangeLight);
    }
}
