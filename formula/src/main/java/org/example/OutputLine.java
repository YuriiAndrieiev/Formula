package org.example;

import java.util.ArrayList;
import java.util.List;

public class OutputLine {

    public List<String> createFinalConsoleLine () {
        ListConsoleLines listConsoleLines = new ListConsoleLines();
        List<ConsoleLine> consoleLineList = listConsoleLines.createListConsoleLines();
        List<String>outputList = new ArrayList<>();
        for (int i = 0; i < consoleLineList.size(); i++) {
            int pos = i+1;
            StringBuilder racerStringBuilder = new StringBuilder(pos +consoleLineList.get(i).getRacer());
            while (racerStringBuilder.length() < 27) {
                racerStringBuilder.append(" ");
            }
            String racer = racerStringBuilder.toString();
            String car = consoleLineList.get(i).getCar();
            String timeLoopString = consoleLineList.get(i).getTimeLoop().toString();
            char[] timeLoopArray = timeLoopString.toCharArray();
            StringBuilder timeLoopStringbuilder = new StringBuilder("|");
            for (int j = 0; j < timeLoopArray.length - 1; j++) {
                if (j != 0 && j != 1 && j != 2) {
                    if (timeLoopArray[j] == 'M') {
                        timeLoopStringbuilder.append(":");
                    } else if (timeLoopArray[j] == '-') {
                        timeLoopStringbuilder.append("");
                    } else {
                        timeLoopStringbuilder.append(timeLoopArray[j]);
                    }
                }
            }
            String loopTime = timeLoopStringbuilder.toString();
            String output = racer.concat(car + loopTime);
            if (outputList.size()==15) {
                outputList.add("------------------------------------------------------------------------");
            }
            outputList.add(output);
        }
        return outputList;
    }
}
