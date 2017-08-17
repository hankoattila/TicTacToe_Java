package com.AvCo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        int tableSize = 3;
        int lineLength = 3;
        List<String> loadTable = new ArrayList<>();
        List<String> names = new ArrayList<>(GuiPanels.getNames());
        String gameType = GuiPanels.selectType();
        String player1 = names.get(0);
        String player2 = names.get(1);
        if (gameType.equals("new")) {
            List<Integer> sizeAndLength = GuiPanels.selectMode();
            tableSize = sizeAndLength.get(0);
            lineLength = sizeAndLength.get(1);
        }

        List<List<String>> myTable = new ArrayList<>();
        if (gameType == "new") {
            Logic game = new Logic(tableSize, lineLength);
            myTable = game.buildTable();
        } else if (gameType == "load") {

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

        new GUI(tableSize, myTable, lineLength, loadTable, player1, player2);
    }
}