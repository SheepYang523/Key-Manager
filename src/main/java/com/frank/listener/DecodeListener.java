package com.frank.listener;

import com.frank.utils.RSAUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecodeListener implements ActionListener {

    public JTextArea textArea;

    private JTextArea keyArea;

    public DecodeListener(JTextArea textArea, JTextArea keyArea) {
        this.textArea = textArea;
        this.keyArea = keyArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pwdEnc = this.textArea.getText();
        String key = this.keyArea.getText();
        if (pwdEnc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Text area is empty", "Enter Text", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            String plain = RSAUtil.privateDecrypt(pwdEnc, key);
            this.textArea.setText(plain);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "1. use or change private key \n\r 2. use correct ciphertext", "Decode", JOptionPane.ERROR_MESSAGE);
        }
    }
}
