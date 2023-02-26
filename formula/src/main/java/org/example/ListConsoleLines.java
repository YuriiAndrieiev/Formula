package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ListConsoleLines {

    public List createListConsoleLines () {
        CreateList createList = new CreateList();
        List <Duration> timeLoopList = createList.createTimeLoopList();
        List <String> racers = createList.createListRacers();
        List<String> cars = createList.CreateListCars();
        List<ConsoleLine> consoleLineList = new ArrayList<>();
        for (int i = 0; i < racers.size(); i++) {
            String racer = racers.get(i);
            String car = cars.get(i);
            Duration timeLoop = timeLoopList.get(i);
            ConsoleLine consoleLine = new ConsoleLine(racer, car, timeLoop);
            consoleLineList.add(consoleLine);
        }
        List<ConsoleLine> consoleLinesSort = new ArrayList<>();
        consoleLineList = consoleLineList.stream()
                .sorted(Comparator.comparing(ConsoleLine::getTimeLoop))
                .collect(Collectors.toList());
        for (int i = consoleLineList.size()-1; i >= 0; i--) {
            consoleLinesSort.add(consoleLineList.get(i));
        }
        return consoleLinesSort ;
    }
}
