package com.AvCo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI {

    int tableSize, lineLength;
    List<List<String>> table = new ArrayList<>();

    public GUI(int tableSize, List<List<String>> table, int lineLength) {

        this.tableSize = tableSize;
        this.table = table;
        this.lineLength = lineLength;

        String[] position = new String[tableSize * tableSize];
        int rowIndex, colIndex;
        int counter = 0;

        for(int i=0; i<tableSize; i++) {
            for(int j=0; j<tableSize; j++) {
                rowIndex = i;
                colIndex = j;
                position[counter] = String.valueOf(rowIndex) + String.valueOf(colIndex);
                counter++;
            }
        }

        System.out.println(Arrays.toString(position));

        XOButton[] buttons = new XOButton[9];
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new XOButton(position[i], tableSize, table, lineLength);
            panel.add(buttons[i]);
        }
        window.add(panel);
        window.setVisible(true);
    }
}
