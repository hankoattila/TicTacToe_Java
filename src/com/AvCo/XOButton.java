package com.AvCo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class XOButton extends JButton implements ActionListener {

    int tableSize, lineLength;
    List<List<String>> table = new ArrayList<>();
    ImageIcon X,O;
    public static int player = 1;
    int empty = 0;

    public XOButton(String name, int tableSize, List<List<String>> table, int lineLength) {
        X = new ImageIcon(this.getClass().getResource("XO_1.png"));
        O = new ImageIcon(this.getClass().getResource("XO_2.png"));
        this.setName(name);
        this.addActionListener(this);
        this.tableSize = tableSize;
        this.table = table;
        this.lineLength = lineLength;
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
            String selectedField = this.getName();
            int rowNum, colNum;
            rowNum = Integer.parseInt(String.valueOf(selectedField.charAt(0)));
            colNum = Integer.parseInt(String.valueOf(selectedField.charAt(1)));
            String sign;
            if(player == 1) {
                sign = "O";
            } else if(player == 2) {
                sign = "X";
            } else {
                sign = "";
            }

            Logic checker = new Logic(tableSize, lineLength);
            String value = checker.checker(table, rowNum, colNum, sign);
            if (value == "Win") {
                player = player == 1 ? 2:1;
                JOptionPane.showMessageDialog(null, "The Winner is: player " + player);
                System.exit(0);
            } else if (value == "GameOver") {
                JOptionPane.showMessageDialog(null, "Shame it's a tie!");
                System.exit(0);
            }
        }
        empty++;
    }
}
