package com.example.hzkto.e_diary;

import android.app.Application;

import com.example.hzkto.e_diary.database.DBSingletone;

/**
 * Created by hzkto on 11/10/2016.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBSingletone.init(getApplicationContext());
    }
}
