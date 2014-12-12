package com.example.mg3142.newssearch.backendTrieAPI;

import java.util.ArrayList;


/**
 * Interface for the Trie data structure
 * Trie is used to search for a word using its prefix
 * @author PaulaKayongo
 */
public interface Trie
{
    /**
     * Creates an empty tree with one node the root that
     * has no value therefore it returns just a singular trie node
     */
    public TrieNode createTrie();

    /**
     * Adds a new word/phrase to the trie given the root node
     */
    public  void insert(String word);

    /**
     * Finds a word/phrase in the Trie data structure given the root node
     */
    public boolean find(String word);


    /**
     * Returns the node that contains the URL arrayList
     * Finds a word/phrase in the Trie data structure given the root node
     */
    public TrieNode search( String word);

    /**
     * Auto compete method for the trie
     */
    public ArrayList<String> autoComplete(char ch);

    /**
     * Prints the trie
     */
    public  void printTree();


    /**
     * Getter method for the root
     */
    public TrieNode getRoot();


    /**
     * Getter method for the trie
     */
    public Trie getTrie();



}

