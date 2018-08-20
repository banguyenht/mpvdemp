package com.example.ba.demomvp.main;

import android.content.Context;

import com.example.ba.demomvp.data.entity.Song;
import com.example.ba.demomvp.data.internal.DataManager;

public class Presenter implements MainContract.Present {
    private Context mContext;
    private DataManager mManager;
    private MainContract.View mView;

    public void setView(MainContract.View view) {
        this.mView = view;
    }

    public Context getContext() {
        return mContext;
    }

    public Presenter(Context context) {
        this.mContext = context;
        mManager = new DataManager();
        mManager.setContext(getContext());
        mManager.loadData();
    }

    @Override
    public void loadDataSongs() {
        mView.onUpdateUi(mManager.getListSong());
    }

    @Override
    public int countSongs() {
        return mManager.getListSong().size();
    }

    @Override
    public Song getItemSong(int positon) {
        return mManager.getListSong().get(positon);
    }
}
