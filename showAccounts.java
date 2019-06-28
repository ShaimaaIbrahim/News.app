package com.example.news;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import com.example.news.data.userContract.NewDb;

import com.example.news.data.UserDbHelper;
import com.example.news.data.userContract;

public class showAccounts extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    NewCursorAdapter adapter;
    private static final int LOADER=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_accounts);
    setTitle("حساباتك");

      adapter=new NewCursorAdapter(this,null);
        ListView listView=(ListView)findViewById(R.id.list_showw);
        listView.setAdapter(adapter);
        getLoaderManager().initLoader(LOADER,null,this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String []projection={
                NewDb._ID,
                NewDb.Username_Column,NewDb.Email_column

        };
        return new CursorLoader(this,NewDb.CONTENT_URI,projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
     adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
 adapter.swapCursor(null);
    }
}
