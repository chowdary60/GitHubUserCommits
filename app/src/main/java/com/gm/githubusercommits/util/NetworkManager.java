package com.gm.githubusercommits.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by madhu on 5/12/19.
 */

public class NetworkManager {
    private Context context;
    public NetworkManager(Context context) {
        this.context = context;
    }
    public boolean isInternetConnectionAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
