package com.AvCo;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI() {
        String[] position = {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        window.add(panel);
        window.setVisible(true);
    }
}
