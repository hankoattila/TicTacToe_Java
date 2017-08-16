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
    GameState gameState = new GameState();
    String outputFile = "testWrite.txt";

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


        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        JMenu menu;
        menu = new JMenu("Menu");
        JMenuItem menuItem = new JMenuItem(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Gergo = "test1";
                String Attila  = "test2";
                gameState.openFile(outputFile, "write");
                gameState.writeFile(table,Gergo,Attila,"test2");
                gameState.closeFile(gameState.getOutputFile());
                System.out.println("Yeaaa!");
            }
        });

        menu.add(menuItem);
        window.setSize(tableSize*120, tableSize*120);
        panel.setLayout(new GridLayout(tableSize,tableSize));
        XOButton[] buttons = new XOButton[(tableSize*tableSize)];
        window.setResizable(false);

        for (int i = 0; i < (tableSize*tableSize); i++) {
            buttons[i] = new XOButton(position[i], tableSize, table, lineLength);
            panel.add(buttons[i]);
        }
        menuBar.add(menu);
        window.add(panel);
        window.setJMenuBar(menuBar);
        window.setVisible(true);
    }
}
