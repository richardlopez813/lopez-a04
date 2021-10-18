/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Solution43Test {
    @Test
    public void test_data_parser(){
        Solution43 sol1 = new Solution43();

        File testFile = new File("C:\\Users\\EMS\\IdeaProjects\\assignment4\\exercise43\\testRandom");
        String testString = sol1.directoryRelavizer(testFile);
        String expectedString = "testRandom";
        assertEquals(expectedString, testString);
    }

}