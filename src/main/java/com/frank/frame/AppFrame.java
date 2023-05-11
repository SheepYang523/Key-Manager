package com.frank.frame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AppFrame extends JFrame {

    private static final LocalProperties properties = LocalProperties.getInstance();

    public AppFrame(String frameTitle) {
        super(frameTitle);
        this.setBounds(properties.screenWidth / 2 - 640 / 2,
                properties.screenHeight / 2 - 480 / 2,
                640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void showFrame() {
        this.setVisible(true);
    }

}
