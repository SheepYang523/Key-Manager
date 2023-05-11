package com.frank.listener;

import com.frank.utils.RSAUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncodeListener implements ActionListener {

    public JTextArea textArea;

    private JTextArea keyArea;

    public EncodeListener(JTextArea textArea, JTextArea keyArea) {
        this.textArea = textArea;
        this.keyArea = keyArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pwd = this.textArea.getText();
        String key = this.keyArea.getText();
        if (pwd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Text area is empty", "Enter Text", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String enc = RSAUtil.publicEncrypt(pwd, key);
            this.textArea.setText(enc);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "use public key", "Encode", JOptionPane.ERROR_MESSAGE);
        }
    }
}
