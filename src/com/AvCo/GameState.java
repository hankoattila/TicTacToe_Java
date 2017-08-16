package com.AvCo;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class GameState {

    private Scanner inputFile = null;
    private BufferedWriter outputFile = null;

    void openFile(String filename, String operation) {
        filename = "/files/" + filename;
        URL url = getClass().getResource(filename);
        filename = url.getFile();
        try {
            if (operation.equals("read")) {
                inputFile = new Scanner(new BufferedReader(new FileReader(filename)));
            } else if (operation.equals("write")) {
                outputFile = new BufferedWriter(new FileWriter(filename));
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

    List<HashMap<String,String>> readFile() {
        List<HashMap<String,String>> mapList = new ArrayList<>();
        while (inputFile.hasNext()) {
            String[] subList;
            String input = inputFile.nextLine();
            subList = input.split(":");
            String[] keyArray = {"id","table","player1","player2","nextPlayer"};
            HashMap<String,String> addNewMap = new HashMap<>();
            for (int i = 0; i< subList.length; i++){
                addNewMap.put(keyArray[i],subList[i]);
            }
            mapList.add(addNewMap);

        }

        return mapList;
    }
    public List<String> oneDimesionTable(String stringTable){
        List<String> oneDimensionList = new ArrayList<>();
        String[] splitedTable = stringTable.split("@");
        for(String stringRow: splitedTable){
            String[] splitedRow = stringRow.split(",");
            for (String field: splitedRow ){
                oneDimensionList.add(field);
            }

        }
        return oneDimensionList;
    }
    public List<List<String>> twoDimensionTable(String stringTable){
        List<List<String>> twoDimensionList = new ArrayList<>();
        String[] splitedTable = stringTable.split("@");
        for(String stringRow: splitedTable){
            String[] splitedRow = stringRow.split(",");
            List<String> asdf = new ArrayList<>();
            for (String element: splitedRow){
                asdf.add(element);
            }

            twoDimensionList.add(asdf);
        }

        return twoDimensionList;
    }

    void printTable(List<List<String>> table) {
        for (List<String> row : table) {
            String rowString = String.join(" ", row);

        }
    }

    void writeFile(List<List<String>> table,String player,String player2, String nextPlayer) {
        String writeString = "0:";
        try {
            for (List<String> row : table) {
                writeString += String.join(",", row);
                writeString += "@";
            }
            writeString += ':' + player + ':' + player2 + ':' + nextPlayer;

            outputFile.write(writeString);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }

    List<List<String>> buildRandomTable(int tableSize) {
        List<List<String>> table = new ArrayList<>();

        for (int i = 0; i < tableSize; i++) {
            List<String> rows = new ArrayList<>();
            Random random = new Random();
            String cell = null;

            for (int j = 0; j < tableSize; j++) {
                int randomInt = random.nextInt(3);
                switch (randomInt) {
                    case 0:
                        cell = "-";
                        break;
                    case 1:
                        cell = "O";
                        break;
                    case 2:
                        cell = "X";
                        break;
                }
                rows.add(cell);
            }
            table.add(rows);
        }
        return table;
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
