package com.EpamLab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        List<String> poem = new ArrayList<>();
        boolean inputFinished = false;
        boolean isLowerCase;

        // input empty lines. If any is empty then stop inputting
        // Split inputted text into separate words and add it to the collection
        while (!inputFinished) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input text line: ");
            String text = scanner.nextLine();
            inputFinished = text.isEmpty();
            if (!inputFinished) {
                poem.addAll(Arrays.asList(text.split("\\s")));
            }
        }

        //Create stream from the collection , make elements unique, sort and collect to list
        List<String> uniqueStream = poem.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // print number of unique words using Stream API
        long uniqueCount = uniqueStream.stream().distinct().count();
        System.out.println("Number of unique words is : " + uniqueCount);

        //Lets count word count. Occurrence number of each word in the text

        //ArrayList is transformed to map. because its easier to filter it by values :) :) :)
        Map<Integer, String> mapPoem = new HashMap<>();
        for (int l = 0; l < poem.size(); l++) {
            mapPoem.put(l, poem.get(l));
        }

        for (String word : uniqueStream) {
            //print each unique word sorted in the first stream
            System.out.println(word + "=");

            //Calculate the count of each word
            long wordCount = mapPoem.entrySet().stream()
                    .filter(element -> element.getValue().equals(word)).distinct()
                    .collect(Collectors.counting());
            System.out.println(wordCount);
        }

        //Calculate the count of each word except upper case characters
        System.out.println("Lets calculate only lower case words:");
        for (String lowword : uniqueStream) {
            if (isLowerCase = Character.isLowerCase(lowword.charAt(0))) {
                System.out.println(lowword + "=");
                long lowerCount = mapPoem.entrySet().stream()
                        .filter(element -> element.getValue().equals(lowword)).distinct()
                        .collect(Collectors.counting());
                System.out.println(lowerCount);
            }
        }
    }
}
