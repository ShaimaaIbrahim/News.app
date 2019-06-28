package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.news.LoaderAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHeadlines extends Fragment implements LoaderManager.LoaderCallbacks<List<New>> {

    private static final String API_NEWS = "https://newsapi.org/v2/top-headlines?country=eg&apiKey=3379295915a840899a7f7d65f8550809";
    private NewsAdapter adapter;

    public FragmentHeadlines() {
        // Required empty public constructor
    }

    ListView listView;
    TextView noInternet;
    TextView textView;
   // View progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // getActivity().setTitle("اخر الاخبار");
        setHasOptionsMenu(true);

        View rootView = inflater.inflate(R.layout.new_list, container, false);
         //progressBar=(ProgressBar)rootView.findViewById(R.id.loading);

        listView = (ListView) rootView.findViewById(R.id.list);
        adapter = new NewsAdapter(getActivity(), new ArrayList<New>());

         textView=(TextView)rootView.findViewById(R.id.empty_view);
        listView.setAdapter(adapter);

        ConnectivityManager connMng = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMng.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
          //  progressBar.setVisibility(View.VISIBLE);
            getActivity().getSupportLoaderManager().initLoader(1, null, this);
            listView.setEmptyView(textView);
        }

        return rootView;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.weather:
                String stringUri = "https://weather.com/ar-DZ/weather/today/l/EGXX0004:1:EG";
                //      Uri.parse(stringUri);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(stringUri));
                startActivity(intent);
                return true;

            case R.id.register:
                Intent intent1 = new Intent(getActivity(), Register.class);
                startActivity(intent1);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @NonNull
    @Override
    public Loader<List<New>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new LoaderAdapter(getActivity(),API_NEWS);
    }

    @Override
    public void onLoadFinished(@NonNull android.support.v4.content.Loader<List<New>> loader, List<New> news) {
        adapter.clear();
        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trig
        if (news != null && !news.isEmpty()) {
            adapter.addAll(news);
        }}

    @Override
    public void onLoaderReset(@NonNull android.support.v4.content.Loader<List<New>> loader) {
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

}
*/
