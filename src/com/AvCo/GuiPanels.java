package com.AvCo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiPanels {

    public static List getNames() {
        String name1 = "";
        String name2 = "";
        List<String> names = new ArrayList<>();
        GameState gameState = new GameState();
        HashMap<String,Integer> highScore = new HashMap<>();
        
        gameState.readHighScore();
        String[] high = new String[]{"Bela Katana", "Juci Nyaralo", "Apu Veddmeg"};
        String score = "<html>High score: <br><br>";
        for (String name: high) {
            score = score + name + "<br>";
        }

        JTextField xField = new JTextField(8);
        JTextField yField = new JTextField(8);
        JLabel jlabel = new JLabel(score);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name 1: "));
        myPanel.add(xField);
        myPanel.add(Box.createVerticalStrut(5));
        myPanel.add(new JLabel("Name 2: "));
        myPanel.add(yField);
        myPanel.add(Box.createVerticalStrut(15));
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(jlabel);
        String panelString = "Please enter your names.";

        while (name1.isEmpty() || name2.isEmpty()) {
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    panelString, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                name1 = xField.getText();
                name2 = yField.getText();
            } else {
                System.exit(0);
            }
            panelString = "Please fill out both fields";
        }
        names.add(name1);
        names.add(name2);
        return names;
    }

    public static String selectType() {

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
            actualGameType = "new";
        } else {
            actualGameType = "load";
        }
        return actualGameType;
    }

    public static List<Integer> selectMode() {
        int tableSize = 0;
        int lineLength = 0;
        List<Integer> sizeLength = new ArrayList<>();

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
        } else if (choice == JOptionPane.NO_OPTION) {
            tableSize = 6;
            lineLength = 5;
        } else {
            System.exit(0);
        }
        sizeLength.add(tableSize);
        sizeLength.add(lineLength);
        return sizeLength;
    }
}
