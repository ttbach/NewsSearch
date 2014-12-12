package com.example.mg3142.newssearch;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.util.Log;

/**
 * An activity representing a single BackendAndGUI detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link BackendAndGUIListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link BackendAndGUIDetailFragment}.
 */
public class BackendAndGUIDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_backendandgui_detail);

            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);

            // savedInstanceState is non-null when there is fragment state
            // saved from previous configurations of this activity
            // (e.g. when rotating the screen from portrait to landscape).
            // In this case, the fragment will automatically be re-added
            // to its container so we don't need to manually add it.
            // For more information, see the Fragments API guide at:
            //
            // http://developer.android.com/guide/components/fragments.html
            //
            if (savedInstanceState == null) {
                // Create the detail fragment and add it to the activity
                // using a fragment transaction.
                Bundle arguments = new Bundle();
                arguments.putString(BackendAndGUIDetailFragment.ARG_ITEM_ID,
                        getIntent().getStringExtra(BackendAndGUIDetailFragment.ARG_ITEM_ID));
                BackendAndGUIDetailFragment fragment = new BackendAndGUIDetailFragment();
                fragment.setArguments(arguments);
                getFragmentManager().beginTransaction()
                        .add(R.id.backendandgui_detail_container, fragment)
                        .commit();
            }
       /* }
       else {
            //create an alert box that tells the user to check their internet connection
            new AlertDialog.Builder(this.getApplicationContext())
                    .setMessage("No Internet connection. Please make sure that you are connected to the internet and try again.")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // close the application
                            finish();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
       */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, BackendAndGUIListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
