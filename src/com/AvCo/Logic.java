package com.AvCo;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    int tableSize;

    public TicTacToe (int tableSize) {
        this.tableSize = tableSize;
    }

    public List buildTable() {

        List<List> table = new ArrayList<>();
        List<String> rows = new ArrayList<>();

        for(int j=0; j<tableSize; j++) {
            rows.add("O");
        }

        for(int i=0; i<tableSize; i++) {
            table.add(rows);
        }

        return table;
    }

    public List selectWithX(List<List> table, int selectedRow, int selectedCol){

        List<String> selRow = table.get(selectedRow);

        selRow.set(selectedCol, "X");

        return table;

    }

    public String checkerLoop(String playerSign, List<String> checkedList, int lineLength) {

        int counter = 0;

        for(String field: checkedList) {
            if(field == playerSign) {
                counter++;
                if(counter == lineLength) {
                    return "Win";
                }
            } else {
                counter = 0;
            }
        } return "Continue";
    }

}
