package resources.styles;

import java.awt.Dimension;

/**
 * Klasa zbiorcza dla wszystkich wymiarów używanych w aplikacji
 */
public class AppDimensions {

    public static int defaultChatWindowWidth = 500;
    public static int defaultChatWindowHeight = 700;

    public static int defaultTextFieldWidth = 500;

    public static int appMargin = 15;

    public static int eastPanelDim = 150;

    public static Dimension textAreaDimension = new Dimension(defaultTextFieldWidth, 0);
    public static Dimension eastPanelDimension = new Dimension(defaultChatWindowWidth + 80, defaultChatWindowHeight + 200);
    public static int messageAreaWidth = defaultChatWindowWidth - 100;
    public static int messageLayoutWidth = defaultChatWindowWidth - 50;

}
