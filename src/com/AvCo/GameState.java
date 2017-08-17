package com.AvCo;

import java.io.*;
import java.util.*;

public class GameState {

    private Scanner inputFile = null;
    private BufferedWriter outputFile = null;
    private int numOfSavedGames = 0;

    void openFile(String filename, String operation) {
        filename = "out/production/TicTacToe_Java/files/" + filename;


        try {
            if (operation.equals("read")) {
                inputFile = new Scanner(new BufferedReader(new FileReader(filename)));
            } else if (operation.equals("write")) {
                // Get number of saves games
                inputFile = new Scanner(new BufferedReader(new FileReader(filename)));
                numOfSavedGames = readFile().size();
                closeFile(inputFile);

                // New input for writing
                inputFile = new Scanner(new BufferedReader(new FileReader(filename)));
                if (numOfSavedGames != 0) {
                    outputFile = new BufferedWriter(new FileWriter(filename, true));
                } else {
                    outputFile = new BufferedWriter(new FileWriter(filename));
                }
                closeFile(inputFile);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    Scanner getInputFile() {
        return inputFile;
    }

    BufferedWriter getOutputFile() {
        return outputFile;
    }

    List<HashMap<String, String>> readFile() {
        List<HashMap<String, String>> mapList = new ArrayList<>();
        while (inputFile.hasNext()) {
            String[] subList;
            String input = inputFile.nextLine();
            subList = input.split(":");
            String[] keyArray = {"id", "table", "player1", "player2", "nextPlayer"};
            HashMap<String, String> addNewMap = new HashMap<>();
            for (int i = 0; i < subList.length; i++) {
                addNewMap.put(keyArray[i], subList[i]);
            }
            mapList.add(addNewMap);

        }

        return mapList;
    }

    public List<String> oneDimensionTable(String stringTable) {
        List<String> oneDimensionList = new ArrayList<>();
        String[] splitTable = stringTable.split("@");
        for (String stringRow : splitTable) {
            String[] splitRow = stringRow.split(",");
            for (String field : splitRow) {
                oneDimensionList.add(field);
            }

        }
        return oneDimensionList;
    }

    public List<List<String>> twoDimensionTable(String stringTable) {
        List<List<String>> twoDimensionList = new ArrayList<>();
        String[] splitArray = stringTable.split("@");
        for (int i = 0; i < splitArray.length; i++) {
            String[] newArray = splitArray[i].split(",");
            List<String> addNew = new ArrayList<>();
            for (int j = 0; j < newArray.length; j++) {
                addNew.add(newArray[j]);
            }
            twoDimensionList.add(addNew);

        }
        return twoDimensionList;
    }

    void writeFile(List<List<String>> table, String player, String player2, int nextPlayer) {
        String writeString = Integer.toString(numOfSavedGames) + ":";
        List<String> tempGameStateList = new ArrayList<>();
        for (List<String> row : table) {
            tempGameStateList.add(String.join(",", row));

        }
        writeString += String.join("@", tempGameStateList);
        writeString += ':' + player + ':' + player2 + ':' + nextPlayer + "\n";
        try {
            outputFile.write(writeString);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    void closeFile(Scanner inputFile) {
        inputFile.close();
    }

    void closeFile(BufferedWriter outputFile) {
        try {
            outputFile.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
