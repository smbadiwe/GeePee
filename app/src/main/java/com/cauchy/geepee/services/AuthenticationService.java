package com.cauchy.geepee.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class AuthenticationService {
    private final String USR = "usr";
    private final String PWD = "pwd";
    private final Context mContext;
    public AuthenticationService(Context context) {
        this.mContext = context;
    }

    public boolean signIn(String username, String password) {
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {

            // Authenticate on the client
            SharedPreferences loginPref = mContext.getSharedPreferences("UserLogin", Context.MODE_PRIVATE);
            if (loginPref != null && loginPref.contains("usr") && loginPref.contains("pwd")) {
                return username.equals(loginPref.getString(USR, null)) &&
                        password.equals(loginPref.getString(PWD, null));
            }

            //TODO: check the server

        }

        return false;
    }

    public void signUp(String lastName, String firstName, String username, String password) {
        if (TextUtils.isEmpty(lastName))
            throw new NullPointerException("lastName cannot be null or empty");
        if (TextUtils.isEmpty(firstName))
            throw new NullPointerException("firstName cannot be null or empty");
        if (TextUtils.isEmpty(username))
            throw new NullPointerException("username cannot be null or empty");
        if (TextUtils.isEmpty(password))
            throw new NullPointerException("password cannot be null or empty");


    }
}
