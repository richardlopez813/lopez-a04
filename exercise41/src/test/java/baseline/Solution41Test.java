package baseline;

import org.junit.jupiter.api.Test;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {
    @Test
    public void test_arraylist_sorter(){
        Solution41 sol1 = new Solution41();
        ArrayList<String> names = new ArrayList<String>();
        names.add("coach");
        names.add("balloon");
        names.add("apple");

        ArrayList<String> expectedList = sol1.sort(names);
        ArrayList<String> ActualList = new ArrayList<String>();
        ActualList.add("apple");
        ActualList.add("balloon");
        ActualList.add("coach");

        assertEquals(expectedList, ActualList);
    }
}