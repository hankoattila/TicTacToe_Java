package com.AvCo;

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

    }
}