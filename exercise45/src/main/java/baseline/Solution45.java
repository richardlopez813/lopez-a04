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
        //declare ArrayList, strings, and Arrays for processing
        //scan information into ArrayList from input file
        //loop through 2d array and replace "utilize" with "use"
        //new scanner
        //prompt for output file name
        //open file with name given (or create it if it does not exist)
        //loop through 2d array and print altered paragraph
        Solution45 sol1 = new Solution45();

        ArrayList<String> text = new ArrayList<String>();
        String sentence = "";
        String[][] arrOfstr = new String[text.size()][];


        try(Scanner input = new Scanner(Paths.get("exercise45_input.txt"))){
            while(input.hasNext()){
                text.add(input.nextLine());
            }
        }
        catch(IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }
        /*
        for(int counter = 0; counter < text.size();counter++){
            sentence = text.get(counter);
            arrOfstr[counter] = sentence.split(" ", 12);
        }
        */
        for(int counter = 0; counter < 3; counter++){
            System.arraycopy(sol1.dataParser(text.get(counter)), 0, arrOfstr,
                    counter, text.get(counter).length());
        }

        for (int counter2 = 0; counter2 < 3; counter2++) {
            for (int counter3 = 0; counter3 < arrOfstr[counter2].length; counter3++) {
                System.out.printf("%s ", arrOfstr[counter2][counter3]);
            }
            System.out.print("\n");
        }

        for (int counter2 = 0; counter2 < arrOfstr.length; counter2++) {
            for (int counter3 = 0; counter3 < arrOfstr[counter2].length; counter3++) {
                if(arrOfstr[counter2][counter3].equals("\"utilize\"")){
                    arrOfstr[counter2][counter3] = "\"use\"";
                }
                if(arrOfstr[counter2][counter3].equals("utilize")){
                    arrOfstr[counter2][counter3] = "use";
                }
                if(arrOfstr[counter2][counter3].equals("utilizes")){
                    arrOfstr[counter2][counter3] = "uses";
                }
            }
        }

        for (int counter2 = 0; counter2 < 3; counter2++) {
            for (int counter3 = 0; counter3 < arrOfstr[counter2].length; counter3++) {
                System.out.printf("%s ", arrOfstr[counter2][counter3]);
            }
            System.out.print("\n");
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter file or directory name:");


        try(Formatter output = new Formatter(input.nextLine())) {
            for (int counter2 = 0; counter2 < 3; counter2++) {
                for (int counter3 = 0; counter3 < arrOfstr[counter2].length; counter3++) {
                    output.format("%s ", arrOfstr[counter2][counter3]);
                }
                output.format("%n");
            }
        }
    }

    public String[] dataParser(String text){
        //declare 2d array
        String[] arrOfstr = new String[12];

        //turn arraylist into 2d array
        for(int counter = 0; counter < text.length();counter++){
            arrOfstr = text.split(",", 3);
        }
        //return array
        return arrOfstr;
    }
}
