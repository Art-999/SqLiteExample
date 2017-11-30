package com.example.arturmusayelyan.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by artur.musayelyan on 30/11/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = " CREATE TABLE " + TableData.TableInfo.TABLE_NAME + "(" + TableData.TableInfo.USER_NAME + " TEXT," + TableData.TableInfo.USER_PASSWORD + " TEXT);";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperations databaseOperations, String name, String password) {
        SQLiteDatabase sqLiteDatabase = databaseOperations.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableInfo.USER_NAME, name);
        contentValues.put(TableData.TableInfo.USER_PASSWORD, password);

        sqLiteDatabase.insert(TableData.TableInfo.TABLE_NAME, null, contentValues);
        Log.d("Database operations", "one row inserted");
    }

    public Cursor getInformation(DatabaseOperations databaseOperations) {
        SQLiteDatabase sqLiteDatabase = databaseOperations.getReadableDatabase();
        String[] columns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASSWORD};
        Cursor cursor = sqLiteDatabase.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }
}
