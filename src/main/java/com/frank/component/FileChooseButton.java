package com.frank.component;

import com.frank.listener.FileChooseListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.File;

public class FileChooseButton extends JButton {

    private JTextComponent[] textComponents;

    public FileChooseButton(JTextComponent... textComponents) {
        this.textComponents = textComponents;
        FileChooseListener listener = new FileChooseListener(this.textComponents);
        this.addActionListener(listener);
    }
}
