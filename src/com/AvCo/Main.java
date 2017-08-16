package com.AvCo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameState gameState = new GameState();
        String filename1 = "test.txt";
        List<List<String>> table;

        gameState.openFile(filename1, "read");
        table = gameState.readFile();
        gameState.printTable(table);
        gameState.closeFile(gameState.getInputFile());

        System.out.println();

        String filename2 = "testWrite.txt";
        int tableSize = 4;
        table = gameState.buildRandomTable(tableSize);
        gameState.printTable(table);
        gameState.openFile(filename2, "write");
        gameState.writeFile(table);
        gameState.closeFile(gameState.getOutputFile());
    }
}
