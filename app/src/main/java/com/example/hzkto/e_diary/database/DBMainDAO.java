package com.example.hzkto.e_diary.database;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by hzkto on 11/10/2016.
 */

public class DBMainDAO extends BaseDaoImpl<DBMain, String> {
    public void clear() {
        try {
            this.delete(this.queryForAll());
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    public DBMainDAO(ConnectionSource connectionSource, Class<DBMain> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }
}
