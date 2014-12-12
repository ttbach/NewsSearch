package com.example.mg3142.newssearch;
/**
 * Created by MG3142 on 11/10/14.
 * After checking that the conditions are satisfied, InputClass class proceeds to call <Newspaper>API Class
 * so that it can be passed to Trie Class and the data structure will be complete/ready
 */
public class InputClass {

    /****************CLASS PROPERTIES****************/
    // trie newyork times
    //trie guardian
    //trie usa today

    // news api newyork
    // news api guardian
    //news api usaToday

    /**
     *
     * @param cc:
     *          ConditionCheck's boolean
     * also, various news api
     * If it is true, then proceed to passing info
     */
    public InputClass(boolean cc) {
        //this.NYAPI = NYAPI
        //this.Guardian = Guardian
        //this.USATodayAPI = USATodayAPI
    }

    /**
     * param NYTimes api
     */
    public void createTrieNY() {

    }

    /**
     * return the NYTimes Trie
     */
    public void getNYTrie(){

    }

    /**
     * return NYAPI
     */
    public void getNYAPI() {

    }
    /**
     * param  GUARDIAN api
     */
    public void createTrieGuardian() {

    }

    /**
     * return the Guardian Trie
     */
    public void getGuardianTrie(){

    }

    /**
     * return GuardianAPI
     */
    public void getGuardianAPI() {

    }

    /**
     * param  USAToday api
     */
    public void createTrieUSAToday() {

    }

    /**
     * return the USAToday Trie
     */
    public void getUSATodayTrie(){

    }

    /**
     * return USATodayAPI
     */
    public void getUSATodayAPI() {

    }

    /**
     * param NEWSAPI
     */
    public void setAPI(){
        //set the new api according to its type
    }

    /**
     * @param word
     *  this is the string that you will search for in the titles
     *  from NYTimes
     *
     *  returns *articles*
     *  depends on how the articles will be returned by the news api classes
     *  assuming String[] will be returned
     *  @return article
     */
    public String[] searchNYTimes(String word) {
        String[] article = null;
        return article;
    }

    /**
     * @param word
     *  this is the string that you will search for in the titles
     *  from Guardian
     *
     *  returns *articles*
     *  depends on how the articles will be returned by the news api classes
     *  assuming String[] will be returned
     *  @return article
     */
    public String[] searchGuardian(String word) {
        String[] article = null;
        return article;
    }

    /**
     * @param word
     *  this is the string that you will search for in the titles
     *  from USAToday
     *
     *  returns *articles*
     *  depends on how the articles will be returned by the news api classes
     *  assuming String[] will be returned
     *  @return article
     */
    public String[] searchUSAToday(String word) {
        String[] article = null;
        return article;
    }
}
