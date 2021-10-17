/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Richard Lopez
 */

package baseline;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) {
        //create object of class
        Solution46 sol1 = new Solution46();

        //declare arraylists, arrays, strings, and counters
        ArrayList<String> text = new ArrayList<>();
        String[][] arrOfstr = new String[4][4];
        String snakeOutput = "Snake:    ";
        String badgerOutput = "Badger:   ";
        String mushroomOutput = "Mushroom: ";
        int counterBadger = 0;
        int counterMushroom = 0;
        int counterSnake = 0;

        //open file and scan info into list
        try (Scanner input = new Scanner(Paths.get("data/exercise46_input.txt"))) {
            while (input.hasNext()) {
                text.add(input.nextLine());
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

        //call data parser and copy array from method into main
        System.arraycopy(sol1.dataParser(text), 0, arrOfstr,
                    0, arrOfstr.length);

        //loop through 2d array to find instances of Badger
        for (int counter = 0; counter < arrOfstr.length; counter++) {
            for (int counter2 = 0; counter2 < arrOfstr[counter].length; counter2++) {
                if (arrOfstr[counter][counter2].contains("badger")) {
                    counterBadger++;
                }
                if (arrOfstr[counter][counter2].contains("snake")) {
                    counterSnake++;
                }
                if (arrOfstr[counter][counter2].contains("mushroom")) {
                    counterMushroom++;
                }
            }
        }

        //call histogramCreator method to complete output strings
        badgerOutput = sol1.histogramCreator(counterBadger,badgerOutput);
        snakeOutput = sol1.histogramCreator(counterSnake, snakeOutput);
        mushroomOutput = sol1.histogramCreator(counterMushroom, mushroomOutput);

        //call print method to display histogram
        sol1.print(counterSnake, counterMushroom, counterBadger,
                snakeOutput, mushroomOutput, badgerOutput);
    }
    public String[][] dataParser (ArrayList<String> paragraph) {
        //declare 2d array
        String[][] twoDarrayOfString = new String[4][4];

        //turn arraylist into 2d array
        for (int counter = 0; counter < paragraph.size(); counter++) {
            String instance = paragraph.get(counter);
            twoDarrayOfString[counter] = instance.split(" ", 4);
        }
        //return array
        return twoDarrayOfString;
    }

    public void print(int counterSnake, int counterMushroom, int counterBadger,
                      String snakeOutput, String mushroomOutput, String badgerOutput){
        //Determine order of histogram and print. checking if snake is biggest
        if (counterSnake > counterMushroom && counterSnake > counterBadger) {
            System.out.printf("%s%n", snakeOutput);
            if (counterMushroom > counterBadger) {
                System.out.printf("%s%n", mushroomOutput);
                System.out.printf("%s%n", badgerOutput);
            } else {
                System.out.printf("%s%n", badgerOutput);
                System.out.printf("%s%n", mushroomOutput);
            }
        }
        //Determine order of histogram and print. checking if mushroom is biggest
        else if (counterMushroom > counterSnake && counterMushroom > counterBadger) {
            System.out.printf("%s%n", mushroomOutput);
            if (counterSnake > counterBadger) {
                System.out.printf("%s%n", snakeOutput);
                System.out.printf("%s%n", badgerOutput);
            } else {
                System.out.printf("%s%n", badgerOutput);
                System.out.printf("%s%n", snakeOutput);
            }
        }
        //Determine order of histogram and print. checking if badger is biggest
        else {
            System.out.printf("%s%n", badgerOutput);
            if (counterSnake > counterMushroom) {
                System.out.printf("%s%n", snakeOutput);
                System.out.printf("%s%n", mushroomOutput);
            } else {
                System.out.printf("%s%n", mushroomOutput);
                System.out.printf("%s%n", snakeOutput);
            }
        }
    }
    public String histogramCreator(int counterWordType, String wordTypeOutput){
        //loop until counter of word type is reached. That # of "*" will be added
        for (int counter = 0; counter < counterWordType; counter++) {
            wordTypeOutput += "*";
        }
        //return output string
        return wordTypeOutput;
    }
}
