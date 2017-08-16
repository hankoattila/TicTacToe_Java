package com.AvCo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public GUI(int size) {

        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        menu = new JMenu("Menu");
        JMenuItem menuItem = new JMenuItem(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Yeaaa!");
            }
        });

        menu.add(menuItem);
        window.setSize(size*150, size*150);
        panel.setLayout(new GridLayout(size,size));
        XOButton[] buttons = new XOButton[(size*size)];
        window.setResizable(false);

        for (int i = 0; i < (size*size); i++) {
            buttons[i] = new XOButton();
            panel.add(buttons[i]);
        }
        menuBar.add(menu);
        window.add(panel);
        window.setJMenuBar(menuBar);
        window.setVisible(true);
    }
}
