package com.AvCo;

import javax.swing.*;

public class XOButton {

    ImageIcon X,O;
    public static int player = 1;
    int empty = 0;

    public XOButton(String name) {
        X = new ImageIcon(this.getClass().getResource("XO_1.png"));
        O = new ImageIcon(this.getClass().getResource("XO_2.png"));

    }

}
