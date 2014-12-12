package com.example.mg3142.newssearch.backendTrieAPI;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Interface for the trie Node that contains no method thus far 
 * This is because all the work in Trie Node in handled in the constructor 
 * @author PaulaKayongo
 *
 */
public interface TrieNode
{

    /**
     * Returns whether the character is a child off the node
     * If so returns the character
     * @param c
     */
    public TrieNodeImp subNode(char c);

    /**
     * Returns the array list containing the URLs associated with the nodes
     */
    public ArrayList<String> getTimesURL();

    /**
     * Returns the array list containing the URLs associated with the nodes
     */
    public ArrayList<String> getGuardURL();

    /**
     * Returns the array list containing the URLs associated with the nodes
     */
    public ArrayList<String> getUsaURL();

    /**
     * Returns the array list containing the titles associated with the node
     */
    public ArrayList<String> getTimesTitles();


    /**
     * Returns the array list containing the titles associated with the node
     */
    public ArrayList<String> getGuardTitles();


    /**
     * Returns the array list containing the titles associated with the node
     */
    public ArrayList<String> getUsaTitles();



    /**
     * Returns the links the content has with other contents
     */
    public LinkedList<TrieNodeImp> getLinks();

    /**
     * Returns the content that is stored at that node
     */
    public char getcontent();

    /**
     *Returns whether the node represents the end of a full word its full word value will therefore be true
     */
    public boolean isEnd();


    /**********************************************************Setter Methods**********************************************/
    public void setTimesURLs(ArrayList<String> url);

    public void setGuardURLs(ArrayList<String> url);

    public void setUsaURLs(ArrayList<String> url);

    public void setTimesTitles(ArrayList<String> titles);

    public void setGuardTitles(ArrayList<String> titles);

    public void setUsaTitles(ArrayList<String> titles);

    public void setIsEnd(boolean val);




}
