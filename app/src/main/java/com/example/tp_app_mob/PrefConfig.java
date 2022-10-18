package com.example.tp_app_mob;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {


    private static final String LIST_KEY = "list_key";

    public static void writeListInPref(Context context, List<ContactFile> list){
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static List<ContactFile> readListFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY, "");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ContactFile>>() {}.getType();
        List<ContactFile> list = gson.fromJson(jsonString, type);
        return list;
    }



    public static void delListInPref(Context context){

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(LIST_KEY);
        editor.apply();



    }
}
