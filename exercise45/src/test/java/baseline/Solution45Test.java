package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test {
    @Test
    public void test_data_parser(){
        Solution45 sol1 = new Solution45();

        ArrayList<String> data = new ArrayList<String>();
        data.add("this is just a test");
        data.add("to see how this parser");
        data.add("is working");

        String[][] twoDarrayOfstring = new String[3][15];
        String[][] expectedArray = {
                {
                        "this", "is", "just", "a", "test"

                }, //row1
                {
                        "to", "see", "how", "this", "parser"
                }, //row2
                {
                        "is", "working"
                }
        };

        System.arraycopy(sol1.dataParser(data), 0, twoDarrayOfstring,
                0, twoDarrayOfstring.length);

        assertArrayEquals(expectedArray, twoDarrayOfstring);
    }
}