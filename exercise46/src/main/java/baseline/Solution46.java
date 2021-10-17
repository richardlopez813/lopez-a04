package baseline;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) {
        //declare Arraylists, Arrays, Strings, and Counters
        //open file and scan info into list
        //call dataParser method
        //loop through 2d array, counting each instance of the words
        //concat String of word type with corresponding number of astericks
        //nested if statements to determine order of print
        //print histogram
        ArrayList<String> text = new ArrayList<String>();
        String[][] arrOfstr = new String[4][];
        String sentence = "";
        String snakeOutput = "Snake:    ";
        String badgerOutput = "Badger:   ";
        String mushroomOutput = "Mushroom: ";
        int counterBadger = 0;
        int counterMushroom = 0;
        int counterSnake = 0;

        try(Scanner input = new Scanner(Paths.get("exercise46_input.txt"))){
            while(input.hasNext()){
                text.add(input.nextLine());
            }
        }
        catch(IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }

        for(int counter = 0; counter < text.size();counter++){
            sentence = text.get(counter);
            arrOfstr[counter] = sentence.split(" ", 5);
        }

        //loop through 2d array to find instances of Badger
        for (int counter = 0; counter < arrOfstr.length; counter++) {
            for (int counter2 = 0; counter2 < arrOfstr[counter].length; counter2++) {
                if(arrOfstr[counter][counter2].contains("badger")){
                    counterBadger++;
                }
            }
        }
        //loop through 2d array to find instances of Mushroom
        for (int counter = 0; counter < arrOfstr.length; counter++) {
            for (int counter2 = 0; counter2 < arrOfstr[counter].length; counter2++) {
                if(arrOfstr[counter][counter2].contains("mushroom")){
                    counterMushroom++;
                }
            }
        }
        //loop through 2d array to find instances of Snake
        for (int counter = 0; counter < arrOfstr.length; counter++) {
            for (int counter2 = 0; counter2 < arrOfstr[counter].length; counter2++) {
                if(arrOfstr[counter][counter2].contains("snake")){
                    counterSnake++;
                }
            }
        }
        //badger output string
        for(int counter = 0; counter < counterBadger; counter++){
            badgerOutput += "*";
        }
        //Snake output string
        for(int counter = 0; counter < counterSnake; counter++){
            snakeOutput += "*";
        }
        //Mushroom output string
        for(int counter = 0; counter < counterMushroom; counter++){
            mushroomOutput += "*";
        }

        if(counterSnake > counterMushroom && counterSnake > counterBadger)
        {
            System.out.printf("%s\n", snakeOutput);
            if(counterMushroom > counterBadger){
                System.out.printf("%s\n", mushroomOutput);
                System.out.printf("%s\n", badgerOutput);
            }
            else{
                System.out.printf("%s\n", badgerOutput);
                System.out.printf("%s\n", mushroomOutput);
            }
        }
        else if(counterMushroom > counterSnake && counterMushroom > counterBadger)
        {
            System.out.printf("%s\n", mushroomOutput);
            if(counterSnake > counterBadger){
                System.out.printf("%s\n", snakeOutput);
                System.out.printf("%s\n", badgerOutput);
            }
            else{
                System.out.printf("%s\n", badgerOutput);
                System.out.printf("%s\n", snakeOutput);
            }
        }
        //counterBadger is largest
        else{
            System.out.printf("%s\n", badgerOutput);
            if(counterSnake > counterMushroom){
                System.out.printf("%s\n", snakeOutput);
                System.out.printf("%s\n", mushroomOutput);
            }
            else{
                System.out.printf("%s\n", mushroomOutput);
                System.out.printf("%s\n", snakeOutput);
            }
        }
    }

    public String[][] dataParser(ArrayList<String> paragraph){
        //turn arraylist into 2d array
        //return array
    }
}
