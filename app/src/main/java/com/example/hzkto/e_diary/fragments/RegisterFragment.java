package com.example.hzkto.e_diary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hzkto.e_diary.R;
import com.example.hzkto.e_diary.database.DBMain;
import com.example.hzkto.e_diary.database.DBSingletone;

import java.sql.SQLException;


public class RegisterFragment extends Fragment {
    TextView tvLogin, tvPassword, tvName, tvMidname, tvLastname, tvEmail, tvBirthday;
    Button btnRegister;
    Context context;
    String toastAnswer;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false);
        View v = inflater.inflate(R.layout.fragment_register, null);
        this.context = getContext();
        initView(v);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkRegisterFields()) {
                    try {
                        saveUser();
                        toastAnswer = getString(R.string.user) + " " + tvName.getText() + " " + getString(R.string.successfullyCreated);
                        getActivity().onBackPressed();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        toastAnswer = getString(R.string.writeError);
                    }
                    Toast.makeText(context, toastAnswer, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, R.string.error_field_required, Toast.LENGTH_SHORT).show();
                }
            }

            private void saveUser() throws SQLException {
                DBMain dbMain = new DBMain();
                dbMain.setBirthday(String.valueOf(tvBirthday.getText()));
                dbMain.setEmail(String.valueOf( tvEmail.getText()));
                dbMain.setLastname(String.valueOf( tvLastname.getText()));
                dbMain.setLogin(String.valueOf( tvLogin.getText()));
                dbMain.setMidname(String.valueOf( tvMidname.getText()));
                dbMain.setName(String.valueOf( tvName.getText()));
                dbMain.setBirthday(String.valueOf( tvBirthday.getText()));
                dbMain.setPassword(String.valueOf( tvPassword.getText()));
                DBSingletone.getHelper().getDbMainDAO().create(dbMain);
            }

            private boolean checkRegisterFields() {
                if (TextUtils.isEmpty(tvLogin.getText())) return false;
                if (TextUtils.isEmpty(tvPassword.getText())) return false;
                if (TextUtils.isEmpty(tvName.getText())) return false;
                if (TextUtils.isEmpty(tvMidname.getText())) return false;
                if (TextUtils.isEmpty(tvLastname.getText())) return false;
                if (TextUtils.isEmpty(tvEmail.getText())) return false;
                if (TextUtils.isEmpty(tvBirthday.getText())) return false;
                if (TextUtils.isEmpty(btnRegister.getText())) return false;
                return true;
            }
        });
        return v;
    }

    private void initView(View v) {
        tvLogin = (TextView) v.findViewById(R.id.fragmentRegister_tvLogin);
        tvPassword = (TextView) v.findViewById(R.id.fragmentRegister_tvPassword);
        tvName = (TextView) v.findViewById(R.id.fragmentRegister_tvName);
        tvMidname = (TextView) v.findViewById(R.id.fragmentRegister_tvMidname);
        tvLastname = (TextView) v.findViewById(R.id.fragmentRegister_tvLastname);
        tvEmail = (TextView) v.findViewById(R.id.fragmentRegister_tvEmail);
        tvBirthday = (TextView) v.findViewById(R.id.fragmentRegister_tvBirthday);
        btnRegister = (Button) v.findViewById(R.id.fragmentRegister_btnRegister);
    }

}
