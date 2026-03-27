package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void decodeMessage(String a) {
        String result = "";
        char resChar;
        for (int i = 0; i < a.length(); i++) {
            resChar = a.charAt(i);
            if (resChar == ' ') {
                result += " ";
            } else {
                resChar -= 2;
                result += resChar;
            }
        }
        System.out.println(result);
    }

    public static void caesarCipherDecoded(String a) {
        String result = "";
        char resChar;
        for (int i = 0; i < a.length(); i++) {
            resChar = a.charAt(i);
            if (resChar == ' ') {
                result += " ";
            } else {
                resChar -= 3;
                result += resChar;
            }
        }
        System.out.println(result);
    }

    public static void simpleChatFilter(String message) {
        String filteredMessage = "";
        if (message.contains("stupid")) {
            filteredMessage += message.replace("stupid", "***").toUpperCase();
        } else {
            filteredMessage += message.toUpperCase();
        }
        System.out.printf("Original message: %s\nContains banned word: %b\nFiltered message: %s", message, message.contains("stupid"), filteredMessage);
    }

    public static void passwordSanitizer(String password) {
        String sanitizedPassword = password.trim().toLowerCase();
        System.out.printf("Original password: %s\nCleaned password: %s\nLength: %d\nContains digit: %b\nStarts with letter: %b", password, sanitizedPassword, sanitizedPassword.length(), sanitizedPassword.chars().anyMatch(Character::isDigit), Character.isLetter(sanitizedPassword.charAt(0)));
    }

    public static void characterShiftPuzzle(String puzzle) {
        String newString = "";
        for (int i = 0; i < puzzle.length(); i++) {
            char currentCharacter = puzzle.charAt(i);
            if (i % 2 == 0) {
                currentCharacter += 1;
                newString += currentCharacter;
            } else {
                currentCharacter -= 1;
                newString += currentCharacter;
            }
        }
        System.out.println(newString);
    }

    public static int manualWordCounter(String words) {
        return words.trim().replaceAll("\\s+", " ").split(" ").length;
    }

    public static void chatMessageAnalyzer(String message) {
        int letterCount = 0;
        int spaceCount = 0;
        String cleanedMessage = message.trim().toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (Character.isLetter(currentChar)) {
                letterCount++;
            } else if (String.valueOf(currentChar).equals(" ")) {
                spaceCount++;
            } else {
                System.out.println("Something weird happened!\n");
            }
        }
        System.out.printf("Original message: %s\nCleaned message: %s\nLetters: %d\nSpaces: %d\nUpdated message: %s\nLength: %d", message, cleanedMessage, letterCount, spaceCount, cleanedMessage, cleanedMessage.replaceAll("\\s+", "").length());
    }

    public static void simpleCaesarCipher(String message, int shift) {
        String encodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char currentCharacter = message.charAt(i);
            if (String.valueOf(currentCharacter).equals(" ")) {
                encodedMessage += " ";
            } else if (Character.isLetter(currentCharacter)) {
                currentCharacter += shift;
                encodedMessage += currentCharacter;
            } else {
                System.out.printf("What happened on index %d,\n", i);
            }
        }
        System.out.printf("Encoded Message: %s", encodedMessage);
    }

//    public static void characterTransformer(String word) {
//
//    }

//    public static void trial(String word) {
       /* Sum of multiples of 3 in an array
        Report a typo

        Write a program that accomplishes the following tasks: 1. Accepts an integer 'n' as input which indicates the number of elements to be in the array. 2. Afterward, accepts 'n' number of integers as input for elements of the array. 3. The program should then calculate the sum of all the elements in the array which are multiples of 3. 4. Print the sum of these numbers as output.

        Sample Input 1:

        4
        1
        3
        5
        9
        */

//    }

    public static void classroomAttendance() {
        int numberOfStudents = 10;
        String[] students = {"Bob", "Ben", "Sarah", "Mary", "Hassan", "Ali", "Abib", "Nick", "Nelly", "Mario"};
        boolean[] attendance = new boolean[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            Arrays.fill(attendance, 0, numberOfStudents / 2, true);
            Arrays.fill(attendance, numberOfStudents / 2, numberOfStudents, false);
        }

//      Swap the positions of two students in the array.
        String holder;
        holder = students[0];

        students[0] = students[1];
        students[1] = holder;

//        Mark one student as present or absent by index.
        attendance[1] = false;

//        Count the total number of present students.
        int presentStudents = 0;
        for (int i = 0; i < attendance.length; i++) {
            if (String.valueOf(attendance[i]).equals("true")) {
                presentStudents += 1;
            }
        }

        System.out.printf("Total number of present students: %d", presentStudents);
        for (int i = 0; i < numberOfStudents; i++) {
//            System.out.printf("%d. %s - %s\n", i +1, students[i], attendance[i]);

        }
//        System.out.println(Arrays.toString(students));
    }

    public static void alphabetic(String[] args) {
        // put your code here
        args = new String[]{"a", "b", "z", "c"};
        boolean broken = false;

        for(int i = 0; i < args.length - 1; i++) {
            System.out.println(args[i].compareTo(args[i+1]));
            if (args[i].compareTo(args[i+1]) > 0) {
                broken = true;
                break;
            }
        }

        if (broken) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

    public static void main(String[] args) {
//        decodeMessage("jgnnq yqtnf");
//        caesarCipherDecoded("khoor zruog");
//        passwordSanitizer(" SeCrEt123   ");
//         simpleChatFilter("This game is stupid");
//         simpleChatFilter("This game is awesome!");
//         characterShiftPuzzle("abad");
//         System.out.println(manualWordCounter("      Java    is   fun to  key  learn.     "));
//         System.out.println(manualWordCounter("Java is fun to key learn"));
//         chatMessageAnalyzer(" Java Programming Is Fun ");
//         simpleCaesarCipher("hello aabb!", 1);
//         classroomAttendance();

        Cat casper = new Cat("Casper", 3);
        casper.setAge(4);
        System.out.println(casper.getName());
        System.out.println(casper.getAge());
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}