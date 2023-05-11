package com.frank.component;

import com.frank.listener.DecodeListener;

import javax.swing.*;

public class DecodeBtn extends JButton {

    private JTextArea textArea;

    private JTextArea keyArea;

    public DecodeBtn(JTextArea textArea, JTextArea keyArea) {
        this.textArea = textArea;
        this.keyArea = keyArea;
        this.addActionListener(new DecodeListener(this.textArea, this.keyArea));
    }

}
