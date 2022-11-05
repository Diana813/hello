package resources.layouts;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import resources.layouts.panels.Panel;
import static resources.strings.AppStrings.me;
import resources.styles.AppDimensions;
import static resources.styles.AppDimensions.defaultChatWindowWidth;
import resources.styles.AppFonts;
import static resources.styles.AppImages.user_icon;
import resources.widgets.AppChatMessageTextArea;

public class UserMessageLayout extends Panel {

    private final String message;
    private final JLabel label;

    private final int numberOfRows;


    public UserMessageLayout(String message) {
        numberOfRows = calculateTextAreaNumberOfLines(message);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setPreferredSize(new Dimension(defaultChatWindowWidth - 40, numberOfRows * 25));
        this.setMaximumSize(new Dimension(2000, numberOfRows * 25));
        this.message = message;
        this.label = new JLabel(user_icon);
        this.setAlignmentY(CENTER_ALIGNMENT);
    }

    public void setCorrectAlignment() {
        if (!message.contains(me)) {
            this.add(label);
            this.add(new AppChatMessageTextArea(message, numberOfRows));

        } else {
            this.add(new AppChatMessageTextArea(message, numberOfRows));
            this.add(label);

        }
    }

    private int calculateTextAreaNumberOfLines(String message) {
        AttributedString text = new AttributedString(message);
        Font font = AppFonts.setAppLabelFont(15);
        text.addAttribute(TextAttribute.FONT, font);
        FontRenderContext fontRenderContext = getFontMetrics(font)
                .getFontRenderContext();
        AttributedCharacterIterator charIt = text.getIterator();
        LineBreakMeasurer lineMeasurer = new LineBreakMeasurer(charIt, fontRenderContext);
        float formatWidth = (float) AppDimensions.defaultChatWindowWidth - 40;
        lineMeasurer.setPosition(charIt.getBeginIndex());

        int numberOfLines = 1;
        while (lineMeasurer.getPosition() < charIt.getEndIndex()) {
            lineMeasurer.nextLayout(formatWidth);
            numberOfLines++;
        }

        return numberOfLines;
    }

}
