package com.example.mg3142.newssearch.backendTrieAPI;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Trie Node Implementaion class implements TrieNode interface
 * @author PaulaKayongo
 *
 */

public class TrieNodeImp  implements TrieNode
{
    /**************************************************************Instance Fields*********************************************/

    //whether the value is an end
    private boolean isEnd;
    //number of characters in the word
    int count;
    //A linked list containing the children
    LinkedList<TrieNodeImp> childList;
    //Hold the content
    char content;
    //Hold the URL associated with the word if it a full word for NYTimes
    private ArrayList<String> timesURL;
    //Hold the URL associates with the word if it a full word for Guardian
    private ArrayList<String> guardURL;
    //Hold the URL associates with the word if it a full word for USA today
    private ArrayList<String>usaURL;
    //Holds the Titles associated with the word
    private ArrayList<String> timesTitle;
    //Holds the Titles associated with the word
    private ArrayList<String> guardTitle;
    //Holds the Titles associated with the word
    private ArrayList<String>usaTitle;


    /************************************************************Instance Methods****************************************/
    /**
     * Constructor that takes in a character parameter
     * @param c
     */
    public TrieNodeImp(char c)
    {
        //Sets the childnist to a new linked list  of Trie Nodes
        childList = new LinkedList<TrieNodeImp>();
        //Sets the end as false
        isEnd = false;
        //sets the contents to the character that is passed into the function
        content = c;
        //sets the count to O
        count = 0;
        //Initially the URL is set to null
        timesURL=null;
        //Initially sets guardian URL to null
        guardURL=null;
        //Initially sets  the USA today URL to null
        usaURL=null;
        //initially titles are null
        timesTitle=null;
        //initially titles are null
        guardTitle=null;
        //initially titles are null
        usaTitle=null;

    }

    /**
     * Returns whether the character is a child off the node
     * If so returns the character
     */
    public TrieNodeImp subNode(char c)
    {
        //in the case where the node has children
        if (childList != null)
            //loops through the children
            for (TrieNodeImp eachChild : childList)
                //returns the content of the child list if it it is the passed character
                if (eachChild.content == c)
                    //returns the child
                    return eachChild;
        //else returns the null
        return null;

    }

    /*********************************************************Getter Mehods**********************************/
    /**
     * Returns the array list containing the URLs associated with the nodes
     */
    public ArrayList<String> getTimesURL()
    {
        return timesURL;
    }

    /**
     * Returns the array list containing the URLs associated with the nodes
     */
    public ArrayList<String> getGuardURL()
    {
        return guardURL;
    }

    /**
     * Returns the array list containing the URLs associated with the nodes
     */
    public ArrayList<String> getUsaURL()
    {
        return usaURL;
    }
    /**
     * Returns the array list containing the titles associated with the node
     */
    public ArrayList<String> getTimesTitles()
    {
        return timesTitle;
    }

    /**
     * Returns the array list containing the titles associated with the node
     */
    public ArrayList<String> getGuardTitles()
    {
        return guardTitle;
    }

    /**
     * Returns the array list containing the titles associated with the node
     */
    public ArrayList<String> getUsaTitles()
    {
        return usaTitle;
    }


    /**
     * Returns the children the content has with other contents
     */
    public LinkedList<TrieNodeImp> getLinks()
    {
        return childList;
    }

    /**
     * Returns the content that is stored at that node
     */
    public char getcontent()
    {
        return content;
    }

    /**
     *Returns whether the node represents the end of a full word its full word value will therefore be true
     */
    public boolean isEnd()
    {
        return isEnd;
    }

    /**********************************************************Setter Methods**********************************************/
    public void setTimesURLs(ArrayList<String> url)
    {
        timesURL=url;
    }
    public void setGuardURLs(ArrayList<String> url)
    {
        guardURL=url;
    }
    public void setUsaURLs(ArrayList<String> url)
    {
        usaURL=url;
    }


    public void setTimesTitles(ArrayList<String> titles)
    {
        timesTitle=titles;
    }

    public void setGuardTitles(ArrayList<String> titles)
    {
        guardTitle=titles;
    }

    public void setUsaTitles(ArrayList<String> titles)
    {
        usaTitle=titles;
    }
    public void setIsEnd(boolean val)
    {
        isEnd=val;
    }





}
