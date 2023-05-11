package com.frank.listener;

import com.frank.utils.RSAUtil;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.KeyPair;

public class GenKeyListener implements ActionListener {

    public JFrame parent;

    public GenKeyListener(JFrame parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        KeyPair key = null;
        String publicKey = "";
        String privateKey = "";
        try {
            key = RSAUtil.genKeyPair();
            publicKey = RSAUtil.getPublicKey(key);
            privateKey = RSAUtil.getPrivateKey(key);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this.parent, e.toString(), "Key Generator Error", JOptionPane.ERROR_MESSAGE);
        }

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showDialog(new JLabel(), "Save");
        File file = fc.getSelectedFile();
        try{
            FileWriter fw = new FileWriter(file + "/priKey.pem");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(privateKey);
            bw.close();
            fw.close();
            fw = new FileWriter(file + "/pubKey.pem");
            bw = new BufferedWriter(fw);
            bw.write(publicKey);
            bw.close();
            fw.close();
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(this.parent, e.toString(), "Key Generator Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
