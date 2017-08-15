package com.AvCo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOButton extends JButton implements ActionListener {

    ImageIcon X,O;
    public static int player = 1;
    int empty = 0;

    public XOButton(String name) {
        X = new ImageIcon(this.getClass().getResource("XO_1.png"));
        O = new ImageIcon(this.getClass().getResource("XO_2.png"));
        this.setName(name);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (empty == 0) {
            switch (player) {
                case 1:
                    setIcon(X);
                    player = 2;
                    break;
                case 2:
                    setIcon(O);
                    player = 1;
                    break;
            }
        }
        empty++;
    }
}
