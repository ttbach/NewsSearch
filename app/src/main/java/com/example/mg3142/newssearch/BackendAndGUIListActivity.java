package com.example.mg3142.newssearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mg3142.newssearch.backendTrieAPI.TrieImp;
import com.example.mg3142.newssearch.backendTrieAPI.TrieNode;
/**
 * An activity representing a list of BackendAndGUI. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link BackendAndGUIDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link BackendAndGUIListFragment} and the item details
 * (if present) is a {@link BackendAndGUIDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link BackendAndGUIListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class BackendAndGUIListActivity extends Activity
        implements BackendAndGUIListFragment.Callbacks {
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public static TrieImp bigTrie;
    private boolean mTwoPane;
    private EditText searchBox;
    public BackendAndGUIListActivity() {
        super();
       bigTrie = new TrieImp();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_backendandgui_list);
        //get the list view and set it to front for the index

        searchBox = (EditText)findViewById(R.id.searchText);
        searchBox = (EditText)findViewById(R.id.searchText);
            if (findViewById(R.id.backendandgui_detail_container) != null) {
                // The detail container view will be present only in the
                // large-screen layouts (res/values-large and
                // res/values-sw600dp). If this view is present, then the
                // activity should be in two-pane mode.
                mTwoPane = true;

                // In two-pane mode, list items should be given the
                // 'activated' state when touched.
                ((BackendAndGUIListFragment) getFragmentManager()
                        .findFragmentById(R.id.backendandgui_list))
                        .setActivateOnItemClick(true);
            }

            // TODO: If exposing deep links into your app, handle intents here.
        //}
        /*else {
           */
    }

    /**
     * Callback method from {@link BackendAndGUIListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(BackendAndGUIDetailFragment.ARG_ITEM_ID, id);
            BackendAndGUIDetailFragment fragment = new BackendAndGUIDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.backendandgui_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, BackendAndGUIDetailActivity.class);
            detailIntent.putExtra(BackendAndGUIDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    /** Called when the user clicks the search button */
    public void search(View view) {
        String toSearch = searchBox.getText().toString();
        TrieNode current = bigTrie.search(toSearch);
       BackendAndGUIListFragment.updateSearch(current);
    }
}
