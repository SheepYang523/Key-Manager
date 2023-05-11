package com.frank.component;

import com.frank.listener.GenKeyListener;

import javax.swing.*;

public class GenKeyBtn extends JButton {

    private JFrame parent;

    public GenKeyBtn(JFrame parent) {
        this.parent = parent;
        GenKeyListener listener = new GenKeyListener(this.parent);
        this.addActionListener(listener);
    }

}
