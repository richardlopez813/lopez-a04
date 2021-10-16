package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Solution42 {
    public static void main(String[] args) {
        //create object of Solution class
        Solution42 sol1 = new Solution42();

        //declare arraylist for intake and 2d array for data parsing
        ArrayList<String> nameSalary = new ArrayList<String>();
        String[][] twoDarrayOfstring = new String[7][3];

        //print header
        System.out.printf("%-12s%-12s%-12s%n", "Last", "First", "Salary");
        System.out.println("------------------------------");

        //open input text and scan info into arraylist
        try(Scanner input = new Scanner(Paths.get("exercise42_input.txt"))){
            while(input.hasNext()){
                nameSalary.add(input.nextLine());
            }
        }
        //catch exceptions
        catch(IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }
        //call dataParser and copy array returned from function to main method's array
        System.arraycopy(sol1.dataParser(nameSalary), 0, twoDarrayOfstring,
                0, twoDarrayOfstring.length);

        //for loop to print 2d array
        for(int counter = 0; counter < nameSalary.size();counter++) {
            for (int counter2 = 0; counter2 < twoDarrayOfstring[counter].length; counter2++) {
                System.out.printf("%-12s", twoDarrayOfstring[counter][counter2]);
            }
            System.out.println();
        }
    }

    public String[][] dataParser(ArrayList<String> nameSalary){
        //declare 2d array
        String[][] twoDarrayOfString = new String[7][];

        //turn arraylist into 2d array
        for(int counter = 0; counter < nameSalary.size();counter++){
            String instance = nameSalary.get(counter);
            twoDarrayOfString[counter] = instance.split(",", 3);
        }
        //return array
        return twoDarrayOfString;
    }
}

