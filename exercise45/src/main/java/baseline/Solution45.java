/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Richard Lopez
 */
package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution45 {
    public static void main(String[] args) throws FileNotFoundException {
        //declare object of class
        Solution45 sol1 = new Solution45();
        //declare ArrayList, strings, and Arrays for processing
        ArrayList<String> text = new ArrayList<String>();
        String fileName = "";
        String[][] arrOfstr = new String[3][15];

        //scan information into ArrayList from input file
        try (Scanner input = new Scanner(Paths.get("data/exercise45_input.txt"))) {
            while (input.hasNext()) {
                text.add(input.nextLine());
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

        //call data parser to turn arraylist into 2d array and copy it to main's array
        System.arraycopy(sol1.dataParser(text), 0, arrOfstr,
                0, arrOfstr.length);

        //loop through 2d array and replace "utilize" with "use"
        for (int counter2 = 0; counter2 < arrOfstr.length; counter2++) {
            for (int counter3 = 0; counter3 < arrOfstr[counter2].length; counter3++) {
                if (arrOfstr[counter2][counter3].equals("\"utilize\"")) {
                    arrOfstr[counter2][counter3] = "\"use\"";
                }
                if (arrOfstr[counter2][counter3].equals("utilize")) {
                    arrOfstr[counter2][counter3] = "use";
                }
                if (arrOfstr[counter2][counter3].equals("utilizes")) {
                    arrOfstr[counter2][counter3] = "uses";
                }
            }
        }
        //new scanner for output file name entry
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file or directory name:");
        fileName = input.nextLine();

        //call output method to take array and output it to text file in specified directory
        sol1.fileOutput(arrOfstr, fileName);
    }

    public String[][] dataParser (ArrayList<String> text) {
        //declare 2d array
        String[][] twoDarrayOfString = new String[3][15];

        //turn arraylist into 2d array
        for (int counter = 0; counter < text.size(); counter++) {
            String instance = text.get(counter);
            twoDarrayOfString[counter] = instance.split(" ", 15);
        }
        //return array
        return twoDarrayOfString;
    }

    public void fileOutput(String[][] arrOfstr, String fileName){
        //create output text file based on input
        try (Formatter output = new Formatter(fileName)) {
            //loop through 2d array and output it to text file
            for (int counter2 = 0; counter2 < 3; counter2++) {
                for (int counter3 = 0; counter3 < arrOfstr[counter2].length; counter3++) {
                    output.format("%s ", arrOfstr[counter2][counter3]);
                }
                output.format("%n");
            }
        //catch if file not found
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}