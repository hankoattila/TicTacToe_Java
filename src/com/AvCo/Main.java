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
    }
}
