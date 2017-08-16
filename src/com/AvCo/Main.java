package com.AvCo;

import java.util.HashMap;
import java.util.List;
//import java.util.Scanner;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        int tableSize = 0;
        int lineLength = 0;

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
        } else if (choice == JOptionPane.NO_OPTION) {
            tableSize = 6;
            lineLength = 5;
        } else {
            System.exit(0);
        }
        Logic game = new Logic(tableSize);
        GameState gameState = new GameState();
        List<List<String>> myTable;
        myTable = game.buildTable();
        String filename1 = "test.txt";
        gameState.openFile(filename1, "read");
        List<HashMap<String,String>> table;
        table = gameState.readFile();
        gameState.closeFile(gameState.getInputFile());
        //myTable = gameState.twoDimensionTable(table.get(0).get("table"));
        System.out.println(myTable);


        new GUI(tableSize, myTable, lineLength);





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