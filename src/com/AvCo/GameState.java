package com.AvCo;

import java.io.*;
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

    List<List<String>> readFile() {
        List<List<String>> strList = new ArrayList<>();
        while (inputFile.hasNext()) {
            List<String> subList = new ArrayList<>();
            String input = inputFile.nextLine();
            String[] strArr = input.split(",");
            for (String elem : strArr) {
                subList.add(elem);
            }
            strList.add(subList);
        }
        return strList;
    }

    void printTable(List<List<String>> table) {
        for (List<String> row : table) {
            String rowString = String.join(" ", row);
            System.out.println(rowString);
        }
    }

    void writeFile(List<List<String>> table) {
        try {
            for (List<String> row : table) {
                String rowString = String.join(",", row);
                outputFile.write(rowString + "\n");
            }
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
