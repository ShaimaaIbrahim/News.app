package com.example.news.Model;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.news.R;
import com.example.news.UtilsWeather;
import com.example.news.Adapters.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;

public class Weather extends AppCompatActivity {
   private static String  API_WEATHER= "http://api.openweathermap.org/data/2.5/forecast/daily?q=cairo&units=metric&appid=20a6fe517fa01dc2fa55d30800608121&fbclid=IwAR32R09F9pDTPxw0o6ZkuZ0M8JgQTYDm3YljSYs5OW4OPD6tPG_44tckiG8";
  private WeatherAdapter adapter;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        setTitle("الطقس الاسبوعي");
        ListView listView=(ListView)findViewById(R.id.list_weather);

        adapter=new WeatherAdapter(this,new ArrayList<Weat>());
        listView.setAdapter(adapter);

        AsyncTaskLoader taskLoader=new AsyncTaskLoader();
        taskLoader.execute(API_WEATHER);

    }
    public class AsyncTaskLoader extends AsyncTask<String ,Void,List<Weat>>{

        @Override
        protected List<Weat> doInBackground(String... strings) {
            if (strings.length < 1 || strings[0] == null) {
                return null;
            }
           List<Weat> result= UtilsWeather.fetchEarthquakeData(strings[0]);
           return result;
        }

        @Override
        protected void onPostExecute(List<Weat>weat) {
            adapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if ( weat!= null && !weat.isEmpty() ) {
                adapter.addAll(weat);
            }
        }

}}
