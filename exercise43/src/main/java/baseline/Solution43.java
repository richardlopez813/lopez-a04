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
        //declaring object of class
        Solution43 sol1 = new Solution43();

        //declaring scanner & string variables
        Scanner scanner = new Scanner(System.in);
        String authorName = "";
        String siteName = "";
        String javaScript = "";
        String css = "";

        //prompt and scan for site name
        System.out.print("Site name: ");
        siteName = scanner.nextLine();

        //prompt and scan for author name
        System.out.print("Author: ");
        authorName = scanner.nextLine();

        //prompt and scan for java folder
        System.out.print("Do you want a folder for JavaScript? ");
        javaScript = scanner.nextLine();

        //prompt and scan for css folder
        System.out.print("Do you want a folder for CSS? ");
        css = scanner.nextLine();

        //getting current directory and adding website folder to it
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory += "\\website\\"+siteName;

        //create folder in directory
        File websiteFolder = new File(currentDirectory);

        //if created print it was created
        if(websiteFolder.mkdir()){
            sol1.printerStatement(websiteFolder);
        }
        //create html file
        File websiteHtml = new File(currentDirectory + "index.htm");

        //write to html file using bufferedwritter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(websiteHtml))){
            bufferedWriter.write("<title>" + siteName + "</title>\n");
            bufferedWriter.write("<author>" + authorName + "</author>");
            sol1.printerStatement(websiteHtml);
            }

        //if yes for folder make folder and if made print it has been made
        if(javaScript.equalsIgnoreCase("y")){
            File javaScriptFolder = new File(currentDirectory + "\\js");
            if(javaScriptFolder.mkdir()){
                sol1.printerStatement(javaScriptFolder);
            }
        }
        //if yes for folder make folder and if made print it has been made
        if(css.equalsIgnoreCase("y")){
            File cssFolder = new File(currentDirectory + "\\css");
            if(cssFolder.mkdir()){
                sol1.printerStatement(cssFolder);
            }
        }
    }

    public String directoryRelavizer(File file){
        //declare absolute path
        File absolutePath = new File("C:\\Users\\EMS\\IdeaProjects\\assignment4\\exercise43");

        //change paths to URI format
        URI path1 = file.toURI();
        URI path2 = absolutePath.toURI();

        //create relative path using relativize
        URI relativePath = path2.relativize(path1);
        String path = relativePath.getPath();

        //return path
        return path;
    }

    public void printerStatement(File file){
        //print output statement
        System.out.printf("Created .%s%n", directoryRelavizer(file));
    }
}