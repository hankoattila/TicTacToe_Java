package com.AvCo;

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
        } else {
            // Atiék cucca ide jön
        }

	    new GUI(tableSize, myTable, lineLength);
    }
}