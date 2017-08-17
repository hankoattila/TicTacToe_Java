package com.AvCo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<String> names = new ArrayList<>(guiPanels.getNames());
        String gameType = guiPanels.selectType();
        List<Integer> sizeAndLength = guiPanels.selectMode();
        int tableSize = sizeAndLength.get(0);
        int lineLength = sizeAndLength.get(1);

        List<List<String>> myTable = new ArrayList<>();
        if (gameType == "New game") {
            Logic game = new Logic(tableSize, lineLength);
            myTable = game.buildTable();
        } else if (actualGameType == "loadGame") {
            
            GameState gameState = new GameState();
            String filename1 = "gameState.txt";
            gameState.openFile(filename1, "read");
            List<HashMap<String, String>> table;
            table = gameState.readFile();
            XOButton.player = Integer.parseInt(table.get(0).get("nextPlayer"));
            gameState.closeFile(gameState.getInputFile());
            myTable = gameState.twoDimensionTable(table.get(0).get("table"));
            loadTable = gameState.oneDimensionTable(table.get(0).get("table"));
        }

        HashMap<String, Integer> highScore = new HashMap<>();
        highScore.put("Peter", 4);
        String name = "Gergo";
        if (!highScore.containsKey(name)) {
            highScore.put(name, 1);
        } else {

            highScore.put(name, highScore.get(name) + 1);
        }
        System.out.println(name + " " + highScore.get(name));

        new GUI(tableSize, myTable, lineLength, loadTable, player1, player2);
    }
}