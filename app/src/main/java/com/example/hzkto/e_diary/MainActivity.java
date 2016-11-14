package com.example.hzkto.e_diary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hzkto.e_diary.database.DBMain;
import com.example.hzkto.e_diary.database.DBMainDAO;
import com.example.hzkto.e_diary.database.DBSingletone;
import com.example.hzkto.e_diary.fragments.LoginFragment;

import java.sql.SQLException;

/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends AppCompatActivity {

    private static Context context;
    private LoginFragment loginFragment;
    public static Context getAppContext() {
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = getApplicationContext();
        loginFragment = new LoginFragment();
        init();
        loadFragment();

        // Set up the login form.

    }

    private void init() {
        DBMainDAO dbMainDAO = DBSingletone.getHelper().getDbMainDAO();
        try {
            if (dbMainDAO.countOf() == 0) {
                dbMainDAO.clear();
                DBMain dbMainItem = new DBMain("admin", "1234");
                dbMainDAO.create(dbMainItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, loginFragment)
                .commit();
    }
}

