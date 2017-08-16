package com.AvCo;

import java.util.List;
//import java.util.Scanner;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        int tableSize, lineLength;

        Object[] val = {"Small","Medium"};
        int choice = JOptionPane.showOptionDialog(null,
                "Please select a table size!",
                "Choose an option",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                val,
                val[0]);

        if (choice == JOptionPane.YES_OPTION) {
            tableSize = 3;
            lineLength = 3;
        } else {
            tableSize = 6;
            lineLength = 5;
        }
        List<List<String>> myTable;
        Logic game = new Logic(tableSize);
        myTable = game.buildTable();

	    new GUI(tableSize, myTable, lineLength);


//        GameState gameState = new GameState();
//        String filename1 = "test.txt";
//        List<List<String>> table;

//        gameState.openFile(filename1, "read");
//        table = gameState.readFile();
//        gameState.printTable(table);
//        gameState.closeFile(gameState.getInputFile());

//        System.out.println();
//
//        String filename2 = "testWrite.txt";
//        int tableSize = 4;
//        table = gameState.buildRandomTable(tableSize);
//        gameState.printTable(table);
//        gameState.openFile(filename2, "write");
//        gameState.writeFile(table);
//        gameState.closeFile(gameState.getOutputFile());

    }
}