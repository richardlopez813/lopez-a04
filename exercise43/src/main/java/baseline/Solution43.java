package baseline;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Solution43 {
    public static void main(String[] args) throws IOException {
        //declare variables
        //prompt for site name
        //scan site name
        //prompt for author name
        //scan for author name
        //ask for javascript folder
        //scan answer
        //ask for CSS folder
        //scan for answer
        //set directory to current
        //print path to website
        //call html method
        //if statement to create JavaScript folder is yes then create file
        //if not continue and print folder not created
        //if yes print file directory
        //if statement to create css folder is yes then create file
        //if not continue and print file directory
        //if yes print file directory
        Scanner scanner = new Scanner(System.in);
        String authorName = "";
        String siteName = "";
        String javaScript = "";
        String css = "";

        System.out.print("Site name: ");
        siteName = scanner.nextLine();

        System.out.print("Author: ");
        authorName = scanner.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        javaScript = scanner.nextLine();

        System.out.print("Do you want a folder for CSS? ");
        css = scanner.nextLine();

        String currentDirectory = System.getProperty("user.dir");
        currentDirectory += "\\website"+"\\"+siteName;

        File websiteFolder = new File(currentDirectory);
        File absolutePath = new File("C:\\Users\\EMS\\IdeaProjects\\assignment4\\exercise43");

        URI path1 = websiteFolder.toURI();
        URI path2 = absolutePath.toURI();

        URI relativePath = path2.relativize(path1);
        String path = relativePath.getPath();

        System.out.printf("Created .%s\n",path);

        if(javaScript.equalsIgnoreCase("y")){
            File javaScriptFolder = new File(currentDirectory + "\\js");
            System.out.printf("Created %s\n", javaScriptFolder.getCanonicalPath());
        }
        if(css.equalsIgnoreCase("y")){
            File cssFolder = new File(currentDirectory + "\\css");
            System.out.printf("Created %s\n", cssFolder.getCanonicalPath());
        }

        /*
        if(websiteFolder.mkdir()){
            System.out.print("created");
        }
        */


    }

    public void htmlWriter(String authorName, String siteName){
        //open html file
        //create html file with title and author
        //print html file directory
    }
}
