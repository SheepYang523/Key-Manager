package com.frank;


import com.frank.component.DecodeBtn;
import com.frank.component.EncodeBtn;
import com.frank.component.FileChooseButton;
import com.frank.component.GenKeyBtn;
import com.frank.frame.AppFrame;

import javax.swing.*;
import java.awt.*;


public class KeyManagerApp{

    public static void main(String[] args) {
        // frame initialize
        AppFrame appFrame = new AppFrame("Key Manager");
        Container frameContainer = appFrame.getContentPane();
        SpringLayout mainlayout = new SpringLayout();
        frameContainer.setLayout(mainlayout);
        Spring pwdSpring = Spring.constant(10);
        Spring normSpring = Spring.constant(10);
        Spring rightSpring = Spring.constant(10);
        Spring zeroSpring = Spring.constant(0);

        // password text area
        JScrollPane scrollPane = new JScrollPane();
        JTextArea passwordArea = new JTextArea();
        passwordArea.setLineWrap(true);
        scrollPane.setViewportView(passwordArea);
        scrollPane.setPreferredSize(new Dimension((int) (appFrame.getWidth() * 0.4), 0));

        // right panel
        JPanel rightPanel = new JPanel();
        SpringLayout rightSpringLayout = new SpringLayout();
        rightPanel.setLayout(rightSpringLayout);

        // button panel
        JPanel btnPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(2, 2);
        btnPanel.setLayout(gridLayout);
        btnPanel.setPreferredSize(new Dimension(0, (int) (0.2 * appFrame.getHeight())));
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);

        JTextArea keyArea = new JTextArea();
        JScrollPane scrollKeyArea = new JScrollPane();
        keyArea.setLineWrap(true);
        scrollKeyArea.setViewportView(keyArea);
        JTextField keyFilePath = new JTextField();
        keyFilePath.setEditable(false);
        keyFilePath.setText("select pem file");

        // buttons
        FileChooseButton fileBtn = new FileChooseButton(keyArea, keyFilePath);
        fileBtn.setText("Select Key");

        GenKeyBtn genKeyBtn = new GenKeyBtn(appFrame);
        genKeyBtn.setText("Gen Key");

        DecodeBtn decodeBtn = new DecodeBtn(passwordArea, keyArea);
        decodeBtn.setText("Decode");

        EncodeBtn encodeBtn = new EncodeBtn(passwordArea, keyArea);
        encodeBtn.setText("Encode");

        // add buttons to button panel
        btnPanel.add(fileBtn);
        btnPanel.add(genKeyBtn);
        btnPanel.add(encodeBtn);
        btnPanel.add(decodeBtn);

        // add component to right panel
        rightPanel.add(btnPanel);
        rightSpringLayout.putConstraint(SpringLayout.NORTH, btnPanel, zeroSpring, SpringLayout.NORTH, rightPanel);
        rightSpringLayout.putConstraint(SpringLayout.WEST, btnPanel, zeroSpring, SpringLayout.WEST, rightPanel);
        rightSpringLayout.putConstraint(SpringLayout.EAST, btnPanel, zeroSpring, SpringLayout.EAST, rightPanel);

        rightPanel.add(keyFilePath);
        rightSpringLayout.putConstraint(SpringLayout.NORTH, keyFilePath, normSpring, SpringLayout.SOUTH, btnPanel);
        rightSpringLayout.putConstraint(SpringLayout.WEST, keyFilePath, zeroSpring, SpringLayout.WEST, rightPanel);
        rightSpringLayout.putConstraint(SpringLayout.EAST, keyFilePath, zeroSpring, SpringLayout.EAST, rightPanel);
        keyFilePath.setPreferredSize(new Dimension(0, 40));
        keyFilePath.setFont(new Font("Arial", Font.PLAIN, 13));

        rightPanel.add(scrollKeyArea);
        rightSpringLayout.putConstraint(SpringLayout.NORTH, scrollKeyArea, normSpring, SpringLayout.SOUTH, keyFilePath);
        rightSpringLayout.putConstraint(SpringLayout.WEST, scrollKeyArea, zeroSpring, SpringLayout.WEST, rightPanel);
        rightSpringLayout.putConstraint(SpringLayout.EAST, scrollKeyArea, zeroSpring, SpringLayout.EAST, rightPanel);
        rightSpringLayout.putConstraint(SpringLayout.SOUTH, scrollKeyArea, Spring.minus(zeroSpring), SpringLayout.SOUTH, rightPanel);


        // add components
        frameContainer.add(scrollPane);
        mainlayout.putConstraint(SpringLayout.WEST, scrollPane, pwdSpring, SpringLayout.WEST, frameContainer);
        mainlayout.putConstraint(SpringLayout.SOUTH, scrollPane, Spring.minus(pwdSpring), SpringLayout.SOUTH, frameContainer);
        mainlayout.putConstraint(SpringLayout.NORTH, scrollPane, pwdSpring, SpringLayout.NORTH, frameContainer);

        frameContainer.add(rightPanel);
        mainlayout.putConstraint(SpringLayout.WEST, rightPanel, rightSpring, SpringLayout.EAST, scrollPane);
        mainlayout.putConstraint(SpringLayout.NORTH, rightPanel, rightSpring, SpringLayout.NORTH, frameContainer);
        mainlayout.putConstraint(SpringLayout.EAST, rightPanel, Spring.minus(rightSpring), SpringLayout.EAST, frameContainer);
        mainlayout.putConstraint(SpringLayout.SOUTH, rightPanel, Spring.minus(rightSpring), SpringLayout.SOUTH, frameContainer);

        appFrame.showFrame();
    }
}






/*
*
*     public KeyManagerApp() {
        // TODO Auto-generated constructor stub
        Container container = getContentPane();
        SpringLayout springLayout = new SpringLayout();
        container.setLayout(springLayout);
        JLabel topicLabel = new JLabel("主题 :");
        JLabel contentLabel = new JLabel("内容 :");
        final JTextField textField = new JTextField(30);
        JTextArea textArea = new JTextArea(3, 30);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(textArea);
        textArea.setLineWrap(true);
        final JButton confirmButton = new JButton("取消");
        JButton cancelButton = new JButton("确认");
        Spring st = Spring.constant(10);
        Spring st2 = Spring.constant(30);
        container.add(topicLabel);
        springLayout.putConstraint(SpringLayout.NORTH, topicLabel, st,SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, topicLabel, st,SpringLayout.WEST, container);
        container.add(textField);
        springLayout.putConstraint(SpringLayout.WEST, textField, st2, SpringLayout.EAST, topicLabel);
        springLayout.putConstraint(SpringLayout.NORTH, textField, 0,SpringLayout.NORTH, topicLabel);
        springLayout.putConstraint(SpringLayout.EAST, textField, Spring.minus(st),SpringLayout.EAST, container);
        container.add(contentLabel);
        springLayout.putConstraint(SpringLayout.WEST, contentLabel, 0, SpringLayout.WEST, topicLabel);
        springLayout.putConstraint(SpringLayout.NORTH, contentLabel, st, SpringLayout.SOUTH, topicLabel);
        container.add(scrollPane);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, contentLabel);
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, textField);
        springLayout.putConstraint(SpringLayout.EAST, scrollPane, Spring.minus(st), SpringLayout.EAST, container);
        container.add(confirmButton);
        springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, Spring.minus(st), SpringLayout.NORTH, confirmButton);
        springLayout.putConstraint(SpringLayout.EAST, confirmButton, Spring.minus(st), SpringLayout.EAST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, confirmButton, Spring.minus(st), SpringLayout.SOUTH, container);
        container.add(cancelButton);
        springLayout.putConstraint(SpringLayout.EAST, cancelButton, Spring.minus(st), SpringLayout.WEST, confirmButton);
        springLayout.putConstraint(SpringLayout.NORTH, cancelButton, 0, SpringLayout.NORTH, confirmButton);
        // make the text field focused every time the window is activated
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                // TODO Auto-generated method stub
                textField.requestFocus();
            }
        });
    }
* */