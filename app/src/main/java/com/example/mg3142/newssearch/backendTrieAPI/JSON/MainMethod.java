package com.example.mg3142.newssearch.backendTrieAPI.JSON;

import com.example.mg3142.newssearch.backendTrieAPI.Trie;
import com.example.mg3142.newssearch.backendTrieAPI.TrieImp;
import com.example.mg3142.newssearch.backendTrieAPI.TrieNode;

/**
 * Created by MG3142 on 12/9/14.
 */
public class MainMethod {
    public static void main(String[] args) {
       Trie holder= new TrieImp();
        //gets an instance of the trie that is already stored
        //This prevents recreation of a empty trie every time the application runs
        Trie trie= holder.getTrie();
        char[] branch = new char[50];

        TrieNode obama = holder.search("obama");
        System.out.println(obama.getGuardTitles());
        System.out.println(obama.getGuardURL());
        System.out.println(obama.getTimesTitles());
        System.out.println(obama.getTimesURL());
        System.out.println(obama.getUsaTitles());
        System.out.println(obama.getUsaURL());


    }
}
