package com.company;

import javax.swing.*;
import java.awt.*;

public class Form {


    public static void mainForm() {
        JFrame mainFrame = new JFrame("Менеджер паролей");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300,300);
        JMenu menu = new JMenu();


        JButton button1 = new JButton("Press");
        JButton button2 = new JButton("Нажми");
        mainFrame.getContentPane().add(BorderLayout.WEST,button1);
        mainFrame.getContentPane().add(BorderLayout.EAST, button2);
        mainFrame.setVisible(true);
    }

}
