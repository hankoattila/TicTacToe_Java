package com.AvCo;

import java.io.*;
import java.net.URL;
import java.util.*;

public class GameState {

    private Scanner inputFile = null;

    void openFile(String filename, String operation) {
        filename = "/files/" + filename;
        URL url = getClass().getResource(filename);
        filename = url.getFile();
        try {
            if (operation.equals("read")) {
                inputFile = new Scanner(new BufferedReader(new FileReader(filename)));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
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

}
