package com.AvCo;

import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int tableSize, lineLength;

        Object[] val = {"Small","Medium"};
        int choice = JOptionPane.showOptionDialog(null,
                "Please select a table size!",
                "Choose an option",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                val,
                val[0]);

        if (choice == JOptionPane.YES_OPTION) {
            tableSize = 3;
            lineLength = 3;
        } else {
            tableSize = 6;
            lineLength = 5;
        }
        List<List<String>> myTable;
        Logic game = new Logic(tableSize);
        myTable = game.buildTable();

	    new GUI(tableSize, myTable, lineLength);

        for (int i = 0; i < myTable.size(); i++) {
            System.out.println(myTable.get(i));
        }

    }
}