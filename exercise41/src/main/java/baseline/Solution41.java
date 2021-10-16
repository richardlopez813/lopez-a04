package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.*;

public class Solution41 {
    public static void main(String[] args) {
        //declare new object of Solution class
        Solution41 sol1 = new Solution41();

        //declare ArrayList to hold names
        ArrayList<String> names = new ArrayList<String>();

        //scan info from input file into ArrayList
        try(Scanner input = new Scanner(Paths.get("data/exercise41_input.txt"))){
            while(input.hasNext()){
                names.add(input.nextLine());
            }
        }
        //catch exceptions
        catch(IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }

        //call sort method
        names = sol1.sort(names);

        //output header
        try(Formatter output = new Formatter("data/exercise41_output.txt")){
            output.format("total of %d names%n-----------------%n", names.size());
            //loop through ArrayList and print each name alphabetically
            for(String counter: names){
                output.format("%s%n", counter);
            }
        }
        //catch exceptions
        catch (SecurityException | FileNotFoundException | FormatterClosedException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> sort(ArrayList<String> names){
        //call collections sort method to sort list
        Collections.sort(names);
        //return ArrayList
        return names;
    }
}
