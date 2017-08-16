package com.AvCo;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new GUI();

        int rowNum, colNum, tableSize;
        String checker = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Select a table size: ");
        tableSize = input.nextInt();

        List<List> myTable;
        Logic game = new Logic(tableSize);
        myTable = game.buildTable();


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