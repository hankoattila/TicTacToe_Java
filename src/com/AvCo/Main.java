package com.AvCo;

import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int rowNum, colNum, tableSize, lineLength;
        String checker = "";
        Scanner input = new Scanner(System.in);


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
            lineLength = 6;
        }
        List<List> myTable;
        Logic game = new Logic(tableSize);
        myTable = game.buildTable();
        new GUI(tableSize);

        for (int i = 0; i < myTable.size(); i++) {
            System.out.println(myTable.get(i));
        }
        while (checker != "Win") {

            System.out.print("Select a row: ");
            rowNum = input.nextInt();

            System.out.print("Select a column: ");
            colNum = input.nextInt();

            game.selectWithX(myTable, rowNum, colNum);
            checker = game.checker(myTable, rowNum, colNum, 3);

            for (int j = 0; j < myTable.size(); j++) {
                System.out.println(myTable.get(j));
            }
            System.out.println(checker);
        }

    }
}