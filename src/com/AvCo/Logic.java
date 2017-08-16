package com.AvCo;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    int tableSize;

    public Logic (int tableSize) {
        this.tableSize = tableSize;
    }

    public List buildTable() {

        List<List<String>> table = new ArrayList<>();

        for (int i = 0; i< tableSize;i++){

            List<String> rows = new ArrayList<>();

            for (int j = 0; j< tableSize;j++){
                rows.add("");

            }
            table.add(rows);
        }


        return table;
    }

    public void selectField(List<List<String>> table, int selectedRow, int selectedCol, String sign){

        List<String> selRow = table.get(selectedRow);
        selRow.set(selectedCol, sign);

    }

    public String checker(List<List<String>> table, int rowNum, int colNum, int lineLength, String sign) {

        selectField(table, rowNum, colNum, sign);

        List<String> selectedRow;
        List<String> selectedColumn = new ArrayList<>();
        List<String> crossDown = new ArrayList<>();
        List<String> crossUp = new ArrayList<>();
        int crossUpStartRow, crossUpStartCol, crossDownStartCol, crossDownStartRow;
        String playerSign = table.get(rowNum).get(colNum);

        // Selected Row
        selectedRow = table.get(rowNum);

        // Selected Column
        for (int i=0; i<table.size(); i++) {
            selectedColumn.add((table.get(i).get(colNum)));
        }

        //Selected Cross Down
        if(rowNum < colNum){
            crossDownStartCol = colNum-rowNum;
            int countForRow = 0;
            for (int i=crossDownStartCol; i<table.size(); i++) {
                crossDown.add(table.get(countForRow).get(i));
                countForRow++;
            }
        } else {
            crossDownStartRow = rowNum-colNum;
            int countForCol = 0;
            for (int i=crossDownStartRow; i<table.size(); i++) {
                crossDown.add(table.get(i).get(countForCol));
                countForCol++;
            }
        }

        // Selected Cross Up
        if((rowNum + colNum) < (table.size()-1)){
            crossUpStartRow = colNum + rowNum;
            int countCol = 0;
            for (int i=crossUpStartRow; i>=0; i--) {
                crossUp.add(table.get(i).get(countCol));
                countCol++;
            }
        } else {
            crossUpStartCol = colNum - (table.size() - rowNum - 1);
            int countForRow = table.size() - 1;
            for (int i=crossUpStartCol; i<table.size(); i++) {
                crossUp.add(table.get(countForRow).get(i));
                countForRow--;
            }
        }

        // Check the four way
        String resultOfRow = checkerLoop(playerSign, selectedRow, lineLength);
        String resultOfColumn = checkerLoop(playerSign, selectedColumn, lineLength);
        String resultOfCrossDown = checkerLoop(playerSign, crossDown, lineLength);
        String resultOfCrossUp = checkerLoop(playerSign, crossUp, lineLength);

        if(resultOfColumn == "Win" || resultOfRow == "Win" || resultOfCrossDown == "Win" || resultOfCrossUp == "Win"){
            return "Win";
        } else if(checkEmptyFieldsExist(table)){
            return "Continue";
        } else {
            return "GameOver";
        }
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

    public boolean checkEmptyFieldsExist(List<List<String>> table) {

        String emptyField = "";
        boolean isThereEmptyField = false;

        for (List<String> row: table) {
            for (String field: row){
                if(field == emptyField){
                    isThereEmptyField = true;
                }
            }
        } return isThereEmptyField;
    }

}
