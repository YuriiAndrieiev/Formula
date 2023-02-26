package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ReadFiles {

    public List<String> readFileEnd() {
        List<String> fileEnd= new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\projects\\Formula\\formula\\src\\main\\resources\\end.log"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileEnd.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileEnd = (List<String>) fileEnd.stream().sorted().collect(Collectors.toList());
        return fileEnd;
    }

    public List<String> readFileStart() {
        List<String> fileStart= new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\projects\\Formula\\formula\\src\\main\\resources\\start.log"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileStart.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileStart = (List<String>) fileStart.stream().sorted().collect(Collectors.toList());
        return fileStart;
    }

    public List<String> readFileAbbreviations() {
        List<String> fileAbbreviations= new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\projects\\Formula\\formula\\src\\main\\resources\\abbreviations.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileAbbreviations.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileAbbreviations = (List<String>) fileAbbreviations.stream().sorted().collect(Collectors.toList());
        return fileAbbreviations;
    }
}
