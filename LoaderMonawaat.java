package com.example.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import com.example.news.DataMonawaat.*;
import java.util.List;

public class LoaderMonawaat extends AsyncTaskLoader<List<New>> {
    private String mUri;
    public LoaderMonawaat(@NonNull Context context,String mUri) {
        super(context);
        this.mUri=mUri;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<New> loadInBackground() {
        List<New> monawat=Utils.fetchEarthquakeData(mUri);
        return monawat;
    }
}
