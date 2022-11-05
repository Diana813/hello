package resources.styles;

import java.awt.Dimension;

public class AppDimensions {

    public static int defaultChatWindowWidth = 500;
    public static int defaultChatWindowHeight = 700;

    public static int defaultTextFieldWidth = 500;
    public static int defaultTextFieldHeight = 60;

    public static int appMargin = 15;

    public static int eastPanelDim = 150;

    public static Dimension textAreaDimension = new Dimension(defaultTextFieldWidth, 0);
    public static Dimension messageTextAreaDimension = new Dimension(defaultChatWindowWidth - 30, defaultTextFieldHeight);
    public static Dimension messageLayoutDimension = new Dimension(defaultChatWindowWidth - 40, defaultTextFieldHeight + 50);


}
