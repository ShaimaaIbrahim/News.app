package com.example.news.Model;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.news.Fragments.FragmentChannels;
import com.example.news.Adapters.NewsAdapter;
import com.example.news.R;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<New>> {
    private String teuri = FragmentChannels.uri;
    private int position = FragmentChannels.pos;
    NewsAdapter adapter;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
progressBar=(ProgressBar)findViewById(R.id.progress);
        String[] titles = {"الرياضه", "الترفيه", "الصحه", "الاقتصاد", "العلوم", "التكنولوجيا"};
        setTitle(titles[position]);
        ListView listView = (ListView) findViewById(R.id.list_news);
        adapter = new NewsAdapter(this, new ArrayList<New>());
        listView.setAdapter(adapter);
        ConnectivityManager connMng = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMng.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            getSupportLoaderManager().initLoader(1, null, this);
        }


    }



    @NonNull
    @Override
    public Loader<List<New>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new LoaderMonawaat(this, teuri);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<New>> loader, List<New> news) {
        progressBar.setVisibility(View.INVISIBLE);
        adapter.clear();
        if (news != null && !news.isEmpty()) {
            adapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<New>> loader) {
        adapter.clear();

    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     *
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     *
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     *
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     *
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */

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
