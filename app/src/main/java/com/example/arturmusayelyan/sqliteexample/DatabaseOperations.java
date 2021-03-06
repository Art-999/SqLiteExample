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
        Log.d("Database operations", "cursor retrieved");
        return cursor;
    }


    public Cursor getUserPassword(DatabaseOperations databaseOperations, String userName) {
        SQLiteDatabase sqLiteDatabase = databaseOperations.getReadableDatabase();
        String selection = TableData.TableInfo.USER_NAME + " Like ?";
        String columns[] = {TableData.TableInfo.USER_PASSWORD};
        String args[] = {userName};
        Cursor cursor = sqLiteDatabase.query(TableData.TableInfo.TABLE_NAME, columns, selection, args, null, null, null);
        return cursor;
    }

    public void deleteUser(DatabaseOperations databaseOperations, String userName, String password) {
        String selection = TableData.TableInfo.USER_NAME + " Like ? AND " + TableData.TableInfo.USER_PASSWORD + " Like ?";
        // String columns[] = {TableData.TableInfo.USER_PASSWORD};
        String args[] = {userName, password};
        SQLiteDatabase sqLiteDatabase = databaseOperations.getWritableDatabase();
        sqLiteDatabase.delete(TableData.TableInfo.TABLE_NAME, selection, args);
    }

    public void updateUserInfo(DatabaseOperations databaseOperations, String userName, String userPass, String newUserName) {
        SQLiteDatabase sqLiteDatabase = databaseOperations.getWritableDatabase();
        String selesction = TableData.TableInfo.USER_NAME + " LIKE ? AND " + TableData.TableInfo.USER_PASSWORD + " LIKE ?";
        String args[]={userName,userPass};
        ContentValues contentValues=new ContentValues();
        contentValues.put(TableData.TableInfo.USER_NAME,newUserName);
        sqLiteDatabase.update(TableData.TableInfo.TABLE_NAME,contentValues,selesction,args);
    }
}
