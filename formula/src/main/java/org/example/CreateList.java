package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CreateList {

    public List createTimeLoopList () {
        ReadFiles readFiles = new ReadFiles();
        List<String> end = readFiles.readFileEnd();
        List<String> start = readFiles.readFileStart();
        List<String> endDates = new ArrayList<>();
        List<String> startDates = new ArrayList<>();
        end.forEach(string -> endDates.add(string.substring(3)));
        start.forEach(string -> startDates.add(string.substring(3)));
        List<Duration> timeLoopList = new ArrayList<>();
        for (int i = 0; i < startDates.size(); i++) {
            DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
            LocalDateTime startLoop = LocalDateTime.parse(startDates.get(i), time);
            LocalDateTime endLoop = LocalDateTime.parse(endDates.get(i), time);
            Duration timeLoop = Duration.between(endLoop, startLoop);
            timeLoopList.add(timeLoop);
        }
        timeLoopList.stream().sorted().collect(Collectors.toList());
        return  timeLoopList;
    }

    public List<String> createListRacers () {
        ReadFiles readFiles = new ReadFiles();
        List<String>fileAbbreviations = readFiles.readFileAbbreviations();
        List<String>fileAbbreviationsWithoutAbb = new ArrayList<>();
        List<String>racers = new ArrayList<>();
        fileAbbreviations.forEach(string -> fileAbbreviationsWithoutAbb.add(string.substring(4)));
        for (int i = 0;  i < fileAbbreviationsWithoutAbb.size(); i++) {
            int pos = i+1;
            String[]element = fileAbbreviationsWithoutAbb.get(i).split("_");
            for (int j = 0; j < element.length; j++) {
                if (j == 0) {
                        StringBuilder racer = new StringBuilder("." + element[j]);
                        String racerString = racer.toString();
                        racers.add(racerString);
                    }
                }
            }
        return racers;
    }

    public List<String> CreateListCars () {
        ReadFiles readFiles = new ReadFiles();
        List<String> fileAbbreviations = readFiles.readFileAbbreviations();
        List<String> fileAbbreviationsWithoutAbb = new ArrayList<>();
        List<String> cars = new ArrayList<>();
        fileAbbreviations.forEach(string -> fileAbbreviationsWithoutAbb.add(string.substring(4)));
        for (int i = 0; i < fileAbbreviationsWithoutAbb.size(); i++) {
            String[] element = fileAbbreviationsWithoutAbb.get(i).split("_");
            for (int j = 1; j < element.length; j++) {
                    StringBuilder car = new StringBuilder("|" + element[j]);
                    while (car.length() < 36) {
                        car.append(" ");
                    }
                    String carString = car.toString();
                    cars.add(carString);
            }
        }
        return cars;
    }
}
