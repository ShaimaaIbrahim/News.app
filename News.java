package com.example.news;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<New>> {
 private  String  teuri=FragmentChannels.uri;
 private int position=FragmentChannels.pos;
 NewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

       String [] titles={
               "الرياضه","الترفيه","الصحه","الاقتصاد","العلوم","التكنولوجيا"
       };
       setTitle(titles[position]);
        ListView listView = (ListView) findViewById(R.id.list_news);
        adapter = new NewsAdapter(this, new ArrayList<New>());
        listView.setAdapter(adapter);
        ConnectivityManager connMng = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMng.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            getSupportLoaderManager().initLoader(1,null,this);
        }


    }

    @NonNull
    @Override
    public Loader<List<New>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new LoaderMonawaat(this,teuri);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<New>> loader, List<New> news) {
        adapter.clear();
        if (news !=null && !news.isEmpty()){
            adapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<New>> loader) {
          adapter.clear();
    }

    }

   /* public class NEWSAsyncTask extends AsyncTask<String, Void, List<New>> {


        @Override
        protected List<New> doInBackground(String... strings) {
            List list = Utils.fetchEarthquakeData(strings[0]);
            if (strings == null || strings.length < 0) {
                return null;
            } else {
                return list;
            }
        }

        @Override
        protected void onPostExecute(List<New> news) {
            if (news != null && !news.isEmpty()) {
                adapter.clear();
            }
            adapter.addAll(news);

        }
    }

    }*/
