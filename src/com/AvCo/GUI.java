package com.AvCo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        XOButton[] buttons = new XOButton[9];
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
            buttons[i] = new XOButton(position[i], tableSize, table, lineLength);
            panel.add(buttons[i]);
        }
        menuBar.add(menu);
        window.add(panel);
        window.setJMenuBar(menuBar);
        window.setVisible(true);
    }
}
