package com.example.hzkto.e_diary.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by hzkto on 11/14/2016.
 */

@DatabaseTable()
public class DBMain {
    @DatabaseField(id = true)
    public String login;

    @DatabaseField()
    public String password;

    @DatabaseField(canBeNull = true)
    public String name;

    @DatabaseField(canBeNull = true)
    public String midname;

    @DatabaseField(canBeNull = true)
    public String lastname;

    @DatabaseField(canBeNull = true)
    public String email;

    @DatabaseField(canBeNull = true)
    public String birthday;

    public DBMain() {
    }

    public DBMain(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public DBMain(String login, String password, String name, String midname, String lastname, String email, String birthday) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.midname = midname;
        this.lastname = lastname;
        this.email = email;
        this.birthday = birthday;
    }
}
