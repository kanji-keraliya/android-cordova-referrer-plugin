package org.apache.cordova.referrer;

import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import android.util.Log;

public class Referrer extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {

    Bundle extras = intent.getExtras();
    if (extras != null) {
    	String referrerString = extras.getString("referrer");
        String utm_sourceString = extras.getString("utm_source");
        String utm_mediumString = extras.getString("utm_medium");
        String utm_campaignString = extras.getString("utm_campaign");
        if (referrerString != null || utm_sourceString!=null || utm_mediumString!=null || utm_campaignString!=null) {
    	    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    	    Editor edit = sharedPreferences.edit();
    	    edit.putString("referrer", referrerString);
    	    edit.putString("utm_source", utm_sourceString);
    	    edit.putString("utm_medium", utm_mediumString);
    	    edit.putString("utm_campaign", utm_campaignString);
    	    edit.commit();
        }
    }
}
 
} // end of class
