package com.example.hzkto.e_diary.database;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by hzkto on 11/10/2016.
 */

public class DBSingletone {
    private static DBHelper databaseHelper = null;

    public static void init(Context context) {
        databaseHelper = OpenHelperManager.getHelper(context, DBHelper.class);
        databaseHelper.getWritableDatabase();
    }

    public static DBHelper getHelper(){
        return databaseHelper;
    }

}
