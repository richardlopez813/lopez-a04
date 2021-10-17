/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Solution46Test {
    @Test
    public void test_data_parser(){
        Solution46 sol1 = new Solution46();

        ArrayList<String> data = new ArrayList<String>();
        data.add("this is just a");
        data.add("test see how this");
        data.add("is working is working");

        String[][] twoDarrayOfstring = new String[3][4];
        String[][] expectedArray = {
                {
                        "this", "is", "just", "a"

                }, //row1
                {
                        "test", "see", "how", "this"
                }, //row2
                {
                        "is", "working", "is", "working"
                }
        };

        System.arraycopy(sol1.dataParser(data), 0, twoDarrayOfstring,
                0, twoDarrayOfstring.length);

        assertArrayEquals(expectedArray, twoDarrayOfstring);
    }
    @Test
    public void test_histogram_creator(){
        Solution46 sol2 = new Solution46();
        int counterWordType = 5;
        String wordTypeOutput = "";
        String expectedOutput = "*****";

        wordTypeOutput = sol2.histogramCreator(counterWordType, wordTypeOutput);

        assertEquals(expectedOutput, wordTypeOutput);
    }

}