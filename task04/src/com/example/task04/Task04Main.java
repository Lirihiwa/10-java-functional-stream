package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        // your implementation here
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^a-zа-яё0-9]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(10)
                .forEach(e -> System.out.print(e.getKey() + "\n"));
    }
}
