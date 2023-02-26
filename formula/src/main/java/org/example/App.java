package org.example;

import java.util.*;


public class App {

    public static void main(String[] args) {
        OutputLine outputLine = new OutputLine();
        List<String>outputList = outputLine.createFinalConsoleLine();
        outputList.forEach(line -> System.out.println(line));
    }
}
