package com.example.news;

import android.content.Context;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import  android.content.pm.*;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter {
public String date;
public String time;
    public NewsAdapter(Context context, ArrayList<New>arrayList) {
        super(context, 0,arrayList);
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        New currentNew= (New) getItem(position);
        View listView=convertView;
        if (listView==null){
           listView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        String  Publish_At=currentNew.getPublishedAt();
        if (Publish_At.contains("T")){
          String []parts=Publish_At.split("T");
          date=parts[0];
          time=parts[1];  time.substring(0,time.length()-1);
        }
        TextView name=(TextView)listView.findViewById(R.id.date);
        name.setText(date);

        TextView discription=(TextView)listView.findViewById(R.id.discrition);
        if (discription.equals("null")){
            discription.setText("................");
        }
        else {
            discription.setText(currentNew.getDescription());
        }
        TextView PublishedAt=(TextView)listView.findViewById(R.id.time);
        PublishedAt.setText(time);

        TextView title=(TextView)listView.findViewById(R.id.titlee);
        title.setText(currentNew.getTitle());

        ImageView imageView=(ImageView)listView.findViewById(R.id.image_view);
        Picasso.with(getContext()).load(currentNew.getUriImage()).into(imageView, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });


return listView;
    }
}
