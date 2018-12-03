package pisPruefung2018;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class DataFileEntrys {

    //method for adding an Contact (Name, Surname, Phone Number, Email) to Phone Book
    public void addEntry(String input) {
        try {
            //creates new File with path: C:/Users/Williams ThinkPad/Desktop/PisPruefungApp/Entrys.txt
            File newFile = new File("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt");

            //when File does not exists it will be created
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            //writes and append String to File
            FileWriter fileW = new FileWriter(newFile, true); //appends String
            BufferedWriter buffW = new BufferedWriter(fileW);
            buffW.write(input); //writes input String to File
            buffW.newLine(); //Adds new Contact in next Line
            buffW.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showAllEntrys() {

        String text = ""; //empty string for later use
        try {
            //creates Filereader for Entrys.txt file
            FileReader fileR = new FileReader("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt");
            //creates BufferedReader for fileR
            BufferedReader bReader = new BufferedReader(fileR);
            //adds line to string (line equals bReader Line)
            String line = bReader.readLine();
            //adds line by line to string txt
            //note: after the end of an line next line will be printer an other line
            while (line != null) {
                text += line + "\n";
                line = bReader.readLine();
            }
            //close reader
            bReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //returns String with all entrys in Entrys.txt
        return text;
    }

    public String search(String searchString) {
        String result = ""; //empty string for later use
        try {
            //scanner for File entrys.txt
            Scanner sc = new Scanner(new File("/Users/william/Documents/coding/PisPruefungApp/Entrys.txt"));
            //as long as scanner hasNext String line equals sacanner next Line
            //if String line contains searchString(input) set String result to value of line
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.contains(searchString)) {
                    result = line;
                    break; // stops loop if successfull
                } else { //if no Match in Entrys.txt
                    //sets result to Massage
                    result = "No Match found in Phone Book!";
                }
            }
            sc.close(); //importan: close scanner for later File operatios like delete or rename!
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //method searches for input String and delets it
    //then it copys all entrys (without the found String) to temporary File
    //entrys.txt will be deleted after tat
    //then temporary file TempEntrys.txt gets renamed to Entrys.txt
    public void deleteEntry(String searchDeleteString) {

        //file for all entrys in phone book
        File inputFile = new File("Entrys.txt");
        //temporary file for entrys without the deleted one
        File tempFile = new File("TempEntrys.txt");
        //finding input String (searchDeleteString) in Entrys.txt
        String lineToRemove = search(searchDeleteString);
        String currentLine;

        try {
            //reading File
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

            //writes Stringlines from Entrys.txt to Tempentrys.txt without lineToRemove
            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim(); //delete whitspaces at front and end
                if (trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine); //wirtes the line
                writer.newLine(); //writes in next line to seperate Strings in file
            }
            reader.close();
            writer.close();
            //delete Entry.txt
            Files.delete(inputFile.toPath());
            //rename TempEntrys.txt to Entrys.txt
            new File("TempEntrys.txt").renameTo(new File("Entrys.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}