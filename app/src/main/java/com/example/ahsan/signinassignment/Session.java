package com.example.ahsan.signinassignment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

/**
 * Created by Ahsan on 1/17/2017.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx =ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }


    public void setLoggedin(boolean loggedin){
        editor.putBoolean("LogggedInMode", loggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return prefs.getBoolean("loggedInMode", false);
    }
}
