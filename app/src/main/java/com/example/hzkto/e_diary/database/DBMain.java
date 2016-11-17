package com.example.hzkto.e_diary.database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by hzkto on 11/14/2016.
 */

@DatabaseTable()
public class DBMain {
    @DatabaseField(id = true)
    private String login;

    @DatabaseField()
    private String password;

    @DatabaseField(canBeNull = true)
    private String name;

    @DatabaseField(canBeNull = true)
    private String midname;

    @DatabaseField(canBeNull = true)
    private String lastname;

    @DatabaseField(canBeNull = true)
    private String email;

    @DatabaseField(canBeNull = true)
    private String birthday;

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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }
}
