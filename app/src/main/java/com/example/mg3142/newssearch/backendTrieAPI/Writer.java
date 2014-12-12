package com.example.mg3142.newssearch.backendTrieAPI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class writes to the output text file and is only called once at the initialization of this
 * project
 */
public class Writer
{
    //Instance of Thao's class
    private static NewsAPI api;
    //An array list to hold the full word in the trie to be used when refreshing the URL
    private static ArrayList<String> wordlist;
    /***********************************************Methods*********************************************/
    /**
     * Writes into output file after searching the API
     */
    public static void writeToOutput(String Word)
    {
        BufferedWriter writer = null;
        try
        {
            //retrieves the articles
            api.retrieveArticlesNYT(Word);
            api.retrieveArticlesGuard(Word);
            //create a temporary file
            String out=Word+";"+api.getURLNYT()+";"+api.getTitleNYT()+";"+api.getURLGUARD()+";"+api.getTitleGUARD();
            System.out.println(out);
            // Location of file to read
            File file = new File("Output.txt");
            // This will output the full path where the file will be written to...
            System.out.println(file.getCanonicalPath());
            //Initializes the writer
            writer = new BufferedWriter(new FileWriter(file, true));
            out=(out+";");
            writer.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                //writer.close();
            } catch (Exception e) {
            }
        }

    }

    public static void setUpList(String filePath)
    {
        // Location of file to read
        File file = new File(filePath);
        //Initially sets scanner to null
        Scanner scanner=null;
        try
        {
            //scans the the file that that has been passed
            scanner = new Scanner(file);
            //sets the delimiter of the scanner to an enter
            scanner.useDelimiter(",");
            //checks that the scanner has a next line
            while(scanner.hasNext())
            {
                //obtain the line from the scanner
                String word = scanner.next();
                //adds the line to the list
                wordlist.add(word);
            }
            //closes the scanner once it is done reading
            scanner.close();

        }
        //in the case where the file is not found
        catch (FileNotFoundException e)
        {
            //prints out the error to the command line
            e.printStackTrace();
        }
    }

	/*
	public static void main(String[] args)
    {
		//Intilaizes word list
		wordlist=new ArrayList<String>();
		//calls set up word list
		setUpList("Word.txt");
		//Initializes API
		api=new NewsAPI();
		//adds the values to the text
		for (int i = 0; i < wordlist.size(); i++)
		{
			System.out.println(wordlist.get(i));
			writeToOutput(wordlist.get(i));
		}
    }
    */
}
