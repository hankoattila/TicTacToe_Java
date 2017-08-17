package com.AvCo;

import java.util.ArrayList;
import java.util.List;

class Logic {
    
    private int tableSize;
    private int lineLength;

    Logic (int tableSize, int lineLength) {
        this.tableSize = tableSize;
        this.lineLength = lineLength;
    }
    
    
    
    List<List<String>> buildTable() {

        List<List<String>> table = new ArrayList<>();
        String emptyFields = "-";

        for (int i=0; i<tableSize; i++){
            List<String> rows = new ArrayList<>();
            for (int j = 0; j< tableSize;j++){
                rows.add(emptyFields);
            }
            table.add(rows);
        }

        return table;
    }

    private void selectField(List<List<String>> table, int selectedFieldRowNum, int selectedFieldColNum, String sign){

        List<String> selRow = table.get(selectedFieldRowNum);
        selRow.set(selectedFieldColNum, sign);

    }

    String checker(List<List<String>> table, int rowNum, int colNum, String sign) {

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
        for (List<String> row: table) {
            selectedColumn.add((row.get(colNum)));
        }

        //Selected Cross Down
        if (rowNum < colNum){
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
        String resultOfRow = rowChecker(playerSign, selectedRow);
        String resultOfColumn = rowChecker(playerSign, selectedColumn);
        String resultOfCrossDown = rowChecker(playerSign, crossDown);
        String resultOfCrossUp = rowChecker(playerSign, crossUp);

        if(resultOfColumn.equals("Win") || resultOfRow.equals("Win") || resultOfCrossDown.equals("Win") || resultOfCrossUp.equals("Win")){
            return "Win";
        } else if(checkEmptyFieldsExist(table)){
            return "Continue";
        } else {
            return "GameOver";
        }

    }

    private String rowChecker(String playerSign, List<String> checkedList) {

        int counter = 0;

        for (String field: checkedList) {
            if (field.equals(playerSign)) {
                counter++;
                if (counter == lineLength) {
                    return "Win";
                }
            } else {
                counter = 0;
            }
        } return "Continue";

    }

    private boolean checkEmptyFieldsExist(List<List<String>> table) {

        String emptyField = "-";
        boolean isThereEmptyField = false;

        for (List<String> row: table) {
            for (String field: row){
                if (field.equals(emptyField)){
                    isThereEmptyField = true;
                }
            }
        } return isThereEmptyField;

    }

}
