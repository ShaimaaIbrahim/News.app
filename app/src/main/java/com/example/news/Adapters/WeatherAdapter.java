package com.example.news.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.news.Model.Weat;
import com.example.news.R;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter {


    public WeatherAdapter(Context context, ArrayList<Weat>weats) {
        super(context, 0,weats);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Weat currentNew = (Weat) getItem(position);
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.weather_lay, parent, false);
        }

        TextView textView=(TextView)listView.findViewById(R.id.day);

        if (position==0){
            textView.setText("SaturDay");
        }
        else if (position==1){
            textView.setText("SunDay");
        }

        else if (position==2){
            textView.setText("MonDay");
        }
        else if (position==3){
            textView.setText("TuesDay");
        }
        else if (position==4){
            textView.setText("WednesDay");
        }
        else if (position==5){
            textView.setText("ThursDay");
        }
        else{
            textView.setText("FriDay");
        }


        TextView textView4 = (TextView) listView.findViewById(R.id.description);
        textView4.setText(currentNew.getDescription());

        TextView textView2=(TextView)listView.findViewById(R.id.heat);
        textView2.setText(currentNew.getTodayHeat()+" C");

        TextView textView1=(TextView)listView.findViewById(R.id.high);
        textView1.setText(currentNew.getHighHeat()+" C");

        TextView textView3=(TextView)listView.findViewById(R.id.low);
        textView3.setText(currentNew.getLowHeat()+" C");

TextView textView5=(TextView)listView.findViewById(R.id.press);
textView5.setText(currentNew.getPreesHeat()+" Hg");

TextView textView6=(TextView)listView.findViewById(R.id.wind);
textView6.setText(currentNew.getSpeed()+" km/h");

        return listView;

    }
}