package com.example.mg3142.newssearch.backendTrieAPI;
import com.example.mg3142.newssearch.backendTrieAPI.JSON.JSONArray;
import com.example.mg3142.newssearch.backendTrieAPI.JSON.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * NewsAPI retrieves articles from the API
 *
 * Instructions to Run (Same across APIs, except the slight difference method names):
 *
 * 	1. Create an instance of NewsAPI
 * 	2. Call retrieveArticlesNYT and pass in the keyword you want to search
 * 	3. Call getTitleNYT to get the arraylist of all matching titles
 * 	4. Call getURLNYT to get the arraylist of all urls corresponding to matching titles
 *
 * @author thaobach
 *
 */

@SuppressWarnings("all")
public class NewsAPI
{
    /* API Keys */
    private final static String apiNYT = "4c7421068638dead06c90b1ac9acc658:7:70140784"; // api key for NYTimes
    private final static String apiGuard = "c4skv424td55cqb3pfr5f9g8"; // api key for The Guardian
    private final static String apiUSA = "d357m9s5x763pks3sg3nb9et"; //api key for USA Today

    /* Array List for NYTimes*/
    private ArrayList<String> web_url_NYT;
    private ArrayList<String> title_NYT;

    /* Array List for The Guardian*/
    private ArrayList<String> web_url_GUARD;
    private ArrayList<String> title_GUARD;

    /* Array List for USA Today*/
    private ArrayList<String> web_url_USA;
    private ArrayList<String> title_USA;

    /**
     * This is an HTTP Get Request to retrieve articles from the NYTimes
     * @throws Exception
     * @param keyword
     */
    public void retrieveArticlesNYT(String keyword) throws Exception
    {
        // Create the url based on keyword and dates
        String url = "http://api.nytimes.com/svc/search/v2/articlesearch.json?q=" + reformat(keyword) +
                "&begin_date=20141101&end_date=20141101&api-key=" + apiNYT;

        // Create a new URL object
        URL obj = new URL(url);

        // Con is an instance of the url that connects to the API
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Read the JSON
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        // Response is the JSON form of type StringBuffer
        StringBuffer response = new StringBuffer();

        // Append all strings in JSON to response
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // jstr is the string version of the JSON form
        String jstr = response.toString();

        // jsonObj is the JSONObject that corresponds with the JSON form
        JSONObject jsonObj = new JSONObject(jstr);

        // arr is a JSONArray that records the docs array
        JSONArray arr = jsonObj.getJSONObject("response").getJSONArray("docs");

        // Create 2 array lists to hold web urls and their corresponding titles
        web_url_NYT = new ArrayList<String>();
        title_NYT = new ArrayList<String>();

        // Loop through the docs array
        for (int i = 0; i < arr.length(); i++)
        {
            // Add web_urls to the array list web_url_NYT
            web_url_NYT.add(arr.getJSONObject(i).getString("web_url"));

			 /* Comments about JSON Form:
			  *  Some blocks have "name" nested in "headline" as the title
			  *  Others have "main" nested in "headline", which is also the title
			  */

            // If the "name" string in "headline" object is not an empty string, add to array list title
            if (!arr.getJSONObject(i).getJSONObject("headline").optString("name").equals(""))
            {
                title_NYT.add(arr.getJSONObject(i).getJSONObject("headline").optString("name"));
            }

            // If the "main" string in "headline" object is not an empty string, add to array list title
            else
            {
                title_NYT.add(arr.getJSONObject(i).getJSONObject("headline").optString("main"));
            }

        }

        // Removes articles and corresponding urls that don't have the keyword in the title
        condenseList(web_url_NYT, title_NYT, keyword);
    }

    /**
     * This is an HTTP Get Request to retrieve articles from the Guardian
     * @throws Exception
     * @param keyword
     */
    public void retrieveArticlesGuard(String keyword) throws Exception
    {
        // Create the url based on keyword and dates
        String url = "http://content.guardianapis.com/search?q=%22" + reformat(keyword) + "%22&api-key=" + apiGuard;

        // Create a new URL object
        URL obj = new URL(url);

        // Con is an instance of the url that connects to the API
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Read the JSON
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        // Response is the JSON form of type StringBuffer
        StringBuffer response = new StringBuffer();

        // Append all strings in JSON to response
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // jstr is the string version of the JSON form
        String jstr = response.toString();

        // jsonObj is the JSONObject that corresponds with the JSON form
        JSONObject jsonObj = new JSONObject(jstr);

        // arr is a JSONArray that records the docs array
        JSONArray arr = jsonObj.getJSONObject("response").getJSONArray("results");

        // Create 2 array lists to hold web urls and their corresponding titles
        web_url_GUARD = new ArrayList<String>();
        title_GUARD = new ArrayList<String>();

        // Loop through the docs array
        for (int i = 0; i < arr.length(); i++)
        {
            // Add web_urls to the array list web_url_GUARD
            web_url_GUARD.add(arr.getJSONObject(i).getString("webUrl"));

            // Add titles to the array list title_GUARD
            title_GUARD.add(arr.getJSONObject(i).getString("webTitle"));
        }

        // Removes articles and corresponding urls that don't have the keyword in the title
        condenseList(web_url_GUARD, title_GUARD, keyword);
    }

    /**
     * This is an HTTP Get Request to retrieve articles from USA Today
     * @throws Exception
     * @param keyword
     */
    public void retrieveArticlesUSA(String keyword) throws Exception
    {
        // Create the url based on keyword and dates
        String url = "http://api.usatoday.com/open/articles?tag=" + reformat(keyword) + "&encoding=json&api_key=" + apiUSA;

        // Create a new URL object
        URL obj = new URL(url);

        // Con is an instance of the url that connects to the API
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Read the JSON
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        // Response is the JSON form of type StringBuffer
        StringBuffer response = new StringBuffer();

        // Append all strings in JSON to response
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // jstr is the string version of the JSON form
        String jstr = response.toString();

        // jsonObj is the JSONObject that corresponds with the JSON form
        JSONObject jsonObj = new JSONObject(jstr);

        // arr is a JSONArray that records the docs array
        JSONArray arr = jsonObj.getJSONArray("stories");

        // Create 2 array lists to hold web urls and their corresponding titles
        web_url_USA = new ArrayList<String>();
        title_USA = new ArrayList<String>();

        // Loop through the docs array
        for (int i = 0; i < arr.length(); i++)
        {
            // Add links to the array list web_url_USA
            web_url_USA.add(arr.getJSONObject(i).getString("link"));

            // Add titles to the array list title_USA
            title_USA.add(arr.getJSONObject(i).getString("title"));
        }

        // Removes articles and corresponding urls that don't have the keyword in the title
        condenseList(web_url_USA, title_USA, keyword);
    }

    /**
     * Removes the titles that don't contain the keyword along with the url associated with them
     * @param web_url, array list of article web urls
     * @param title, array list of article titles
     * @param keyword, word user searches for
     */
    private void condenseList(ArrayList<String> web_url, ArrayList<String> title, String keyword)
    {
        // Only condense when keyword is a single word
        if (!keyword.contains(" "))
        {
            // List of titles in lowercase
            ArrayList<String> titleToLowerCase = new ArrayList<String>();

            // Convert keyword to lower case
            keyword = keyword.toLowerCase();

            // Convert all titles to lowercase and add results to titleToLowerCase
            for (int i = 0; i < title.size(); i++)
            {
                titleToLowerCase.add(title.get(i).toLowerCase());
            }

            // Loop through title list backwards
            for (int i = title.size()-1; i >= 0; i--)
            {
                // If a title doesn't contain the keyword, remove it and its corresponding url
                if (!titleToLowerCase.get(i).contains(keyword))
                {
                    title.remove(i);
                    web_url.remove(i);
                }
            }
        }
    }

    /**
     * Replaces spaces with a "+" for keywords with more than 1 word
     * @param keyword
     */
    private String reformat(String keyword)
    {
        if (keyword.contains(" "))
        {
            keyword = keyword.replace(" ", "+");
        }
        return keyword;
    }

    /**
     * Retrieves web_url array list of NYTimes
     * @return the array list of urls of articles that contain the keyword
     */
    public ArrayList<String> getURLNYT()
    {
        return web_url_NYT;
    }

    /**
     * Retrieves title array list of NYTimes
     * @return the array list of titles of articles that contain the keyword
     */
    public ArrayList<String> getTitleNYT()
    {
        return title_NYT;
    }

    /**
     * Retrieves web_url array list of The Guardian
     * @return the array list of urls of articles that contain the keyword
     */
    public ArrayList<String> getURLGUARD()
    {
        return web_url_GUARD;
    }

    /**
     * Retrieves title array list of The Guardian
     * @return the array list of titles of articles that contain the keyword
     */
    public ArrayList<String> getTitleGUARD()
    {
        return title_GUARD;
    }

    /**
     * Retrieves web_url array list of The Guardian
     * @return the array list of urls of articles that contain the keyword
     */
    public ArrayList<String> getURLUSA()
    {
        return web_url_USA;
    }

    /**
     * Retrieves title array list of The Guardian
     * @return the array list of titles of articles that contain the keyword
     */
    public ArrayList<String> getTitleUSA()
    {
        return title_USA;
    }



}
