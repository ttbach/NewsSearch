package com.example.mg3142.newssearch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.locks.Condition;

/**
 * Created by MG3142 on 11/10/14.
 */
public class ConditionCheck {
    private Context _context;

    /*****
     * blank constructor
     */
    public ConditionCheck() {

    }
    public ConditionCheck(Context context) {
        this._context = context;
    }

    public void set_context(Context context) {
        this._context = context;
    }
    public boolean checkConnection() {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity!=null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * though not indicated here, the param will be a news api. this function will then checkif the user has the subscription for the news.
     * @return boolean
     */
    public boolean checkSubscription() {
        return false;
    }
}
