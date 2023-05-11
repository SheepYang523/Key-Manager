package com.frank.frame;

import java.awt.*;

public class LocalProperties {
    public int screenWidth;
    public int screenHeight;

    private static final LocalProperties INSTANCE = new LocalProperties();

    private LocalProperties() {
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        this.screenHeight = screenSize.height;
        this.screenWidth = screenSize.width;
    }

    public static LocalProperties getInstance() {
        return INSTANCE;
    }
}
