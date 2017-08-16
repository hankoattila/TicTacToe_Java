package com.AvCo;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int tableSize, lineLength;
        lineLength = 3;
        tableSize = 3;

        List<List<String>> myTable;
        Logic game = new Logic(tableSize);
        myTable = game.buildTable();

	    new GUI(tableSize, myTable, lineLength);

        for (int i = 0; i < myTable.size(); i++) {
            System.out.println(myTable.get(i));
        }

    }
}