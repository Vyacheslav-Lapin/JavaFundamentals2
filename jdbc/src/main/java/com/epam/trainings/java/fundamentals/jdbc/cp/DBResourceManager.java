package com.epam.trainings.java.fundamentals.jdbc.cp;

import java.util.ResourceBundle;

@SuppressWarnings("WeakerAccess")
public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("_java._se._07._connectionpool.db");

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key){
        return bundle.getString(key);
    }
}
