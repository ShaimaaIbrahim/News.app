package com.example.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.Model.New;
import com.example.news.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter {
public String date;
public String time;
    public NewsAdapter(Context context, ArrayList<New>arrayList) {
        super(context, 0,arrayList);
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        final New currentNew= (New) getItem(position);
        View listView=convertView;
        if (listView==null){
           listView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageShare=listView.findViewById(R.id.share);
        final View finalListView = listView;

        imageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);


                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, currentNew.getDescription());

                getContext().startActivity(Intent.createChooser(share, "Share link!"));
            }
        });

        String  Publish_At=currentNew.getPublishedAt();
        if (Publish_At.contains("T")){
          String []parts=Publish_At.split("T");
          date=parts[0];
          time=parts[1];  time.substring(0,time.length()-1);
        }
        TextView name=(TextView)listView.findViewById(R.id.date);
        name.setText(date);

        TextView discription=(TextView)listView.findViewById(R.id.discrition);
        if (discription.equals(null) || discription.equals("")){
            discription.setVisibility(View.GONE);
        }
        else {
            discription.setText(currentNew.getDescription());
        }
        TextView PublishedAt=(TextView)listView.findViewById(R.id.time);
        PublishedAt.setText(time);

        TextView title=(TextView)listView.findViewById(R.id.titlee);
        if (!currentNew.getTitle().equals("") && !currentNew.getTitle().equals(null)) {
            title.setText(currentNew.getTitle());
        }
        else{
            title.setVisibility(View.GONE);
        }
        ImageView imageView=(ImageView)listView.findViewById(R.id.image_view);
        if (!currentNew.getUriImage().equals("") && !currentNew.getUriImage().equals(null)) {
            Picasso.with(getContext()).load(currentNew.getUriImage()).into(imageView, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError() {

                }
            });
        }else{
            imageView.setVisibility(View.GONE);
        }

return listView;
    }
}
