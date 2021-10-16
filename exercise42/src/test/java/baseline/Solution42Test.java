package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {
    @Test
    public void test_data_parser(){
        Solution42 sol1 = new Solution42();

        ArrayList<String> data = new ArrayList<String>();
        data.add("coach,man,running");
        data.add("balloon,red,round");
        data.add("apple,banana,orange");

        String[][] twoDarrayOfstring = new String[3][7];
        String[][] expectedArray = {
                {
                    "coach", "man", "running"
                }, //row1
                {
                    "balloon", "red", "round"
                }, //row2
                {
                    "apple", "banana", "orange"
                }
        };

        System.arraycopy(sol1.dataParser(data), 0, twoDarrayOfstring,
                0, twoDarrayOfstring.length);

        assertArrayEquals(expectedArray, twoDarrayOfstring);
    }

}