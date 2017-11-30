package com.example.arturmusayelyan.sqliteexample;

import android.provider.BaseColumns;

/**
 * Created by artur.musayelyan on 30/11/2017.
 */

public class TableData {
    public TableData() {

    }

    public static abstract class TableInfo implements BaseColumns {
        public static final String USER_NAME = "user_name";
        public static final String USER_PASSWORD = "user_password";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "register_info";
    }
}
