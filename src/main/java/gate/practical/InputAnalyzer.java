package gate.practical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputAnalyzer {
    public static void main(String[] args) {
        boolean running = true;

        List<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while(running) {
            String input = scanner.nextLine();

            switch (input) {
                case "":
                    System.out.println("Empty input");
                break;
                case "exit":
                    running = false;
                    scanner.close();

                    if (result.isEmpty()) {
                        System.out.println("Only empty string found.");
                        return;
                    }

                    System.out.println("Longest: " + findLongest(result));
                    System.out.println("Shortest: " + findShortest(result));
                    System.out.println("Total inputs: " + result.size());
                    System.out.println("Contains digit: " + findStringsWithDigits(result));
                    break;
                default:
                    result.add(input);
            }
        }
    }

     public static String findLongest(List<String> result) {
        String longest = "";

        for (String word: result) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    public static String findShortest(List<String> result) {
        String shortest = result.getFirst();

        for (String word: result) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }
        return shortest;
    }

    public static List<String> findStringsWithDigits(List<String> result) {
        List<String> containInt = new ArrayList<>();

        for (String word: result) {
            var wordArr = word.toCharArray();

            for (char character: wordArr) {
                if (Character.isDigit(character)) {
                    containInt.add(word);
                    break;
                }
            }
        }
        return containInt;
    }
}

