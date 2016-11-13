package com.example.hzkto.e_diary.database;

/**
 * Created by hzkto on 11/10/2016.
 */

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DBHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DBHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "myappname.db";
    private static final int DATABASE_VERSION = 5;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private DBMainDAO dbMainDAO = null;

    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, DBMain.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, DBMain.class, true);

            onCreate(database, connectionSource);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public DBMainDAO getDbMainDAO() throws SQLException {
        if (dbMainDAO == null) try {
            dbMainDAO = new DBMainDAO(getConnectionSource(), DBMain.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return dbMainDAO;
    }



    public void close() {
        super.close();
    }
}
