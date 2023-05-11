package com.frank.component;

import com.frank.listener.EncodeListener;

import javax.swing.*;

public class EncodeBtn extends JButton {

    private JTextArea textArea;

    private JTextArea keyArea;

    public EncodeBtn(JTextArea textArea, JTextArea keyArea) {
        this.textArea = textArea;
        this.keyArea = keyArea;
        this.addActionListener(new EncodeListener(this.textArea, this.keyArea));
    }
}
