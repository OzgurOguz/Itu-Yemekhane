package com.example.ozgur.itu_yemekhane.connectionControl;

import android.content.Context;
import android.net.ConnectivityManager;



public class ConnectionControl {
    Context context;

    public boolean ConnectionControl() {

        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService (Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {

            return false;
        }

    }
}
