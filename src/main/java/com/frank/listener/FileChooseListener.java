package com.frank.listener;

import com.frank.msg.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileChooseListener implements ActionListener {

    private JTextComponent[] textComponents;

    public FileChooseListener(JTextComponent... textComponents) {
        this.textComponents = textComponents;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                String name = f.getName();
                return name.endsWith(".pem");
            }

            @Override
            public String getDescription() {
                return "*.pem";
            }
        });
        fc.showDialog(new JLabel(), "Choose Private or Public Key");
        File file = fc.getSelectedFile();
        for (JTextComponent c : textComponents) {
            if (c instanceof JTextField)
                c.setText(file.getAbsolutePath());
        }
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            StringBuilder res = new StringBuilder();
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            for (JTextComponent c : textComponents) {
                if (c instanceof JTextArea)
                    c.setText(res.toString());
            }
            br.close();
            fr.close();
        }
        catch (Exception exception){
            for (JTextComponent c : textComponents) {
                if (c instanceof JTextField)
                    c.setText("File Read Error");
            }
        }
    }
}
