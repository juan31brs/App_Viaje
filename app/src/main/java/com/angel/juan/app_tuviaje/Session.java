package com.angel.juan.app_tuviaje;


import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("viaje", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLoggedin(boolean logggedin){
        editor.putBoolean("loggedInmode",logggedin);
        editor.commit();
    }

    public boolean loggedin(){
        return sharedPreferences.getBoolean("loggedInmode", false);
    }
}
