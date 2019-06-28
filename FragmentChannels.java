package com.example.news;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentChannels extends Fragment {
public static String uri;
public static  int pos;
    public FragmentChannels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.list_data,container,false);
        setHasOptionsMenu(true);
     final  ArrayList<DataMonawaat>arrayList=new ArrayList<DataMonawaat>();
       arrayList.add(new DataMonawaat(R.drawable.sport,"الرياضه","https://newsapi.org/v2/top-headlines?country=eg&category=sport&apiKey=3379295915a840899a7f7d65f8550809&fbclid=IwAR1cuhPNf6cHukPiFswmrzYTIh8OT-6-uFIgWpST4zTFrd96xwsFZyE8xZA"));
        arrayList.add(new DataMonawaat(R.drawable.enviro,"الفن","https://newsapi.org/v2/top-headlines?country=eg&category=entertainment&apiKey=3379295915a840899a7f7d65f8550809&fbclid=IwAR1cuhPNf6cHukPiFswmrzYTIh8OT-6-uFIgWpST4zTFrd96xwsFZyE8xZA"));
        arrayList.add(new DataMonawaat(R.drawable.health,"الصحه","https://newsapi.org/v2/top-headlines?country=eg&category=health&apiKey=3379295915a840899a7f7d65f8550809&fbclid=IwAR1cuhPNf6cHukPiFswmrzYTIh8OT-6-uFIgWpST4zTFrd96xwsFZyE8xZA"));
        arrayList.add(new DataMonawaat(R.drawable.business,"الاقتصاد","https://newsapi.org/v2/top-headlines?country=eg&category=business&apiKey=3379295915a840899a7f7d65f8550809&fbclid=IwAR1cuhPNf6cHukPiFswmrzYTIh8OT-6-uFIgWpST4zTFrd96xwsFZyE8xZA"));
        arrayList.add(new DataMonawaat(R.drawable.science,"العلوم","https://newsapi.org/v2/top-headlines?country=eg&category=science&apiKey=3379295915a840899a7f7d65f8550809"));
        arrayList.add(new DataMonawaat(R.drawable.tech,"التكنولوجيا","https://newsapi.org/v2/top-headlines?country=eg&category=technology&apiKey=3379295915a840899a7f7d65f8550809"));

        ListView listView=(ListView)rootView.findViewById(R.id.list_data);
        MonawaatAdapter adapter=new MonawaatAdapter(getActivity(),arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataMonawaat dataMonawaat=arrayList.get(position);

                uri=dataMonawaat.getUri();
                pos=position;
                Intent intent=new Intent(getContext(),News.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        inflater.inflate(R.menu.insta, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.insta:
                String stringUri="https://www.instagram.com/abraj.top/";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(stringUri));
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
