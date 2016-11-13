package com.example.hzkto.e_diary;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hzkto.e_diary.database.DBMain;
import com.example.hzkto.e_diary.database.DBMainDAO;
import com.example.hzkto.e_diary.database.DBSingletone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        DBMainDAO dbMainDAO = DBSingletone.getHelper().getDbMainDAO();
        try {
//            if (dbMainDAO.countOf() == 0) {
            DBMain dbMainItem = new DBMain("admin", "1234");
            dbMainDAO.clear();
            try {
                dbMainDAO.create(dbMainItem);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        }
    }
}
