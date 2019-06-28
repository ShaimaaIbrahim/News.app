package com.example.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import com.example.news.New;
import java.util.List;

public class LoaderAdapter extends AsyncTaskLoader<List<New>> {
    private  String muri;
    public LoaderAdapter(@NonNull Context context,String muri) {
        super(context);
        this.muri=muri;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<New> loadInBackground() {
        List<New>earthquakes=Utils.fetchEarthquakeData(muri);
        return earthquakes;
    }
}
