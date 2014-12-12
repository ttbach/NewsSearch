package com.example.mg3142.newssearch;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.mg3142.newssearch.backendTrieAPI.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A fragment representing a single BackendAndGUI detail screen.
 * This fragment is either contained in a {@link BackendAndGUIListActivity}
 * in two-pane mode (on tablets) or a {@link BackendAndGUIDetailActivity}
 * on handsets.
 */
public class BackendAndGUIDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private static ArrayList<String> titleList;
    //private DummyContent.DummyItem mItem;
    private String titles;

    private static ArrayList<String> urlList ;
    //private DummyContent.DummyItem mItem;
    private String url;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BackendAndGUIDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //createTrie();
        super.onCreate(savedInstanceState);
        //index of the title chosen by the user
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //dummy item has a url (content), id (title)
            //dummy item contain one url and one title.
           // mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            url = urlList.get(titleList.indexOf(getArguments().getString(ARG_ITEM_ID)));
           // Log.d("url",content);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_backendandgui_detail,
                container, false);
        // Show the dummy content as text in a webview.
       /* if (mItem != null) {
            WebView current = ((WebView) rootView.findViewById(R.id.backendandgui_detail));
            WebSettings webSettings = current.getSettings();
            webSettings.setDomStorageEnabled(true);
            ((WebView) rootView.findViewById(R.id.backendandgui_detail))
                    .loadUrl(mItem.website_url);
        }*/
        if (url != null || url!="") {
            WebView current = ((WebView) rootView.findViewById(R.id.backendandgui_detail));
            WebSettings webSettings = current.getSettings();
            webSettings.setDomStorageEnabled(true);
            ((WebView) rootView.findViewById(R.id.backendandgui_detail)).loadUrl(url);
        }

        return rootView;
    }

       public static ArrayList<String> getTitles() {
            if(titleList==null){
                String[] tempTitles = {"The New York Times", "The Guardian"};
                titleList = new ArrayList<String>(Arrays.asList(tempTitles));
                String[] tempURLS = {"",""};
                urlList = new ArrayList<String>(Arrays.asList(tempURLS));
            }
           return titleList;
       }

    public static void updateLinks(TrieNode newNode) {
        //search thr trie,
       // TrieNode temp = bigTrie.search(bigTrie.getRoot(), word);
        //titleList = temp.getTitles();
        //urlList = temp.getURL();
        if (!titleList.isEmpty() )
                titleList.clear();
            if (!urlList.isEmpty())
                urlList.clear();

            titleList.add("The New York Times");
            urlList.add("");

            ArrayList<String> nyTitles = newNode.getTimesTitles();
            ArrayList<String> nyUrl = newNode.getTimesURL();

            titleList.addAll(nyTitles);
            urlList.addAll(nyUrl);

            titleList.add("The Guardian");
            urlList.add("");

            ArrayList<String> gTitles = newNode.getGuardTitles();
            ArrayList<String> gUrl = newNode.getGuardURL();

            titleList.addAll(gTitles);
            urlList.addAll(gUrl);

        /*titleList.add("New York Times");
        ArrayList<String> temp = new ArrayList<String>(Arrays.asList(bla2));
        titleList.addAll(temp);
        urlList.add("");
        ArrayList<String> tempURL = new ArrayList<String>(Arrays.asList(content2));
        urlList.addAll(tempURL);*/

         //update the title list
        //update the url list
    }



}
