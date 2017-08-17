package com.AvCo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int tableSize, lineLength;

        JTextField xField = new JTextField(8);
        JTextField yField = new JTextField(8);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name 1: "));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(20));
        myPanel.add(new JLabel("Name 2: "));
        myPanel.add(yField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please enter your names.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name1 = xField.getText();
            String name2 = yField.getText();
        } else {
            System.exit(0);
        }

        String[] gameType = new String[]{"New game", "Load game"};
        int choiceNewGame = JOptionPane.showOptionDialog(null,
                "Do you want to play new game or load a saved one!",
                "Choose an option",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                gameType,
                gameType[0]);

        String actualGameType = "";
        if(choiceNewGame == JOptionPane.YES_OPTION) {
             actualGameType = "New game";
        } else {
            actualGameType = "Load game";
        }

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

        List<List<String>> myTable = new ArrayList<>();
        if (actualGameType == "New game") {
            Logic game = new Logic(tableSize);
            myTable = game.buildTable();
        } else {
            // Atiék cucca ide jön
        }

	    new GUI(tableSize, myTable, lineLength);

    }
}