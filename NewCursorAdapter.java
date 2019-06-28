package com.example.news;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.news.data.UserDbHelper;
import com.example.news.data.userContract;
import com.example.news.data.userContract.NewDb;

public class NewCursorAdapter extends CursorAdapter {
    public NewCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_show,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView textView=(TextView)view.findViewById(R.id.show_username);
        TextView textView1=(TextView)view.findViewById(R.id.show_email);


        int column_username=cursor.getColumnIndex(NewDb.Username_Column);
        int column_email=cursor.getColumnIndex(userContract.NewDb.Email_column);

        String Username=cursor.getString(column_username);
        String email=cursor.getString(column_email);

        textView.setText(Username);
        textView1.setText(email);

    }
}
