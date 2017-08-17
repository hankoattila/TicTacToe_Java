package com.AvCo;

import java.util.HashMap;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int tableSize = 0;
        int lineLength = 0;
        int choice;


        Object[] val = {"Small", "Medium"};
        choice = JOptionPane.showOptionDialog(null,
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
        Logic game = new Logic(tableSize, lineLength);
        GameState gameState = new GameState();
        List<List<String>> myTable;
        myTable = game.buildTable();
        String filename1 = "test.txt";
        gameState.openFile(filename1, "read");
        List<HashMap<String, String>> table;
        table = gameState.readFile();
        XOButton.player = Integer.parseInt(table.get(0).get("nextPlayer"));
        gameState.closeFile(gameState.getInputFile());
        myTable = gameState.twoDimensionTable(table.get(0).get("table"));
        List<String> loadTable;
        loadTable = gameState.oneDimesionTable(table.get(0).get("table"));


        new GUI(tableSize, myTable, lineLength, loadTable);
    }
}