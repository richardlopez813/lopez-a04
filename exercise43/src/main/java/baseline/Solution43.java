/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Richard Lopez
 */

package baseline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        Solution43 sol1 = new Solution43();

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
        currentDirectory += "\\website\\"+siteName;

        File websiteFolder = new File(currentDirectory);

        if(websiteFolder.mkdir()){
            System.out.printf("Created .%s%n",sol1.directoryRelavizer(websiteFolder));
        }

        File websiteHtml = new File(currentDirectory + "index.html");
/*
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(websiteHtml))){
            bufferedWriter.write("<title>" + siteName + "</title>\n");
            bufferedWriter.write("<author>" + authorName + "</author");
            bufferedWriter.write("<html><head><title>New Page</title></head>" +
                        "<body><p>This is Body</p></body></html>");

            //System.out.printf("Created .%s%n", sol1.directoryRelavizer(websiteHtml));
            bufferedWriter.close();
            }
        catch (Exception e) {}
*/
        try (FileWriter fileWriter = new FileWriter(websiteHtml)){
            fileWriter.write("<title>" + siteName + "</title>\n");
            fileWriter.write("<author>" + authorName + "</author");
            fileWriter.write("<html><head><title>New Page</title></head>" +
                    "<body><p>This is Body</p></body></html>");
            fileWriter.close();

            System.out.printf("Created .%s%n", sol1.directoryRelavizer(websiteHtml));
        }
        catch (Exception e) {}

        if(javaScript.equalsIgnoreCase("y")){
            File javaScriptFolder = new File(currentDirectory + "\\js");
            if(javaScriptFolder.mkdir()){
                System.out.printf("Created .%s%n", sol1.directoryRelavizer(javaScriptFolder));
            }
        }
        if(css.equalsIgnoreCase("y")){
            File cssFolder = new File(currentDirectory + "\\css");
            if(cssFolder.mkdir()){
                System.out.printf("Created .%s%n", sol1.directoryRelavizer(cssFolder));
            }
        }
    }

    public String directoryRelavizer(File file){
        File absolutePath = new File("C:\\Users\\EMS\\IdeaProjects\\assignment4\\exercise43");

        URI path1 = file.toURI();
        URI path2 = absolutePath.toURI();

        URI relativePath = path2.relativize(path1);
        String path = relativePath.getPath();

        return path;
    }
}
