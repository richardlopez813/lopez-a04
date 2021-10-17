package baseline;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class Solution44 {
    public static void main(String[] args) throws FileNotFoundException {
        //create json parser
        //create json object
        //convert Json formatted input file into java data structure
        //loop for question prompt
        //prompt for product
        //scan for product
        //if not found loop again
        //if found display properties
        //Gson gson = new Gson();
        JsonParser parser = new JsonParser();

        Object obj = parser.parse(new FileReader("\\data\\exercise44_input.json"));

        JsonObject jsonObject = new JsonObject();

        JsonArray products = (JsonArray) jsonObject.get("name");
    }
}
