package com.example.news.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.news.data.userContract.NewDb;

public class UserDbHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME="user.db";
    private static  int DATABASE_VERSION =1;

    public UserDbHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String SQL_NEW_DATABASE="CREATE TABLE "+ NewDb.TableName +" ("+
             NewDb._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NewDb.Username_Column +" TEXT, "+ NewDb.Email_column+
             " TEXT,"+NewDb.Password_column+ " TEXT, "+NewDb.ConfirmPassword_column+
             " TEXT);" ;
          db.execSQL(SQL_NEW_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
