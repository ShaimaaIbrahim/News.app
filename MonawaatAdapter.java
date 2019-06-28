package com.example.news;
import com.example.news.DataMonawaat;

import android.content.ContentUris;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.news.DataMonawaat;
import com.example.news.MonawaatAdapter;
import java.util.ArrayList;
import java.util.ArrayList;
public class MonawaatAdapter extends ArrayAdapter<DataMonawaat> {


    public MonawaatAdapter(Context context, ArrayList<DataMonawaat>arrayList) {
        super(context,0,arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataMonawaat currentData=getItem(position);
     View listitem=convertView;
     if (convertView==null) {
       listitem=  LayoutInflater.from(getContext()).inflate(R.layout.data, parent, false);
     }

        ImageView imageView=(ImageView)listitem.findViewById(R.id.image_data);
     imageView.setImageResource(currentData.getimage());

        TextView textView=(TextView)listitem.findViewById(R.id.text_data);
        textView.setText(currentData.gettext());

        return listitem;
    }
}
