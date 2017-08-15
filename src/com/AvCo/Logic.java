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

}
