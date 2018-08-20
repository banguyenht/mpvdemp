package com.example.ba.demomvp.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ba.demomvp.R;
import com.example.ba.demomvp.data.entity.Song;
import com.example.ba.demomvp.home.adapter.SongAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SongAdapter.ISongAdapter,
        HomeContract.View {
    private RecyclerView mRecyclerView;
    private SongAdapter mAdapter;
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPresenter = new Presenter(this);
        mPresenter.setView(this);
        mRecyclerView = findViewById(R.id.recyclerview_sogns);
        mAdapter = new SongAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.loadDataSongs();
    }

    @Override
    public int getCount() {
        return mPresenter.countSongs();
    }

    @Override
    public Song getItem(int positon) {
        return mPresenter.getItemSong(positon);
    }

    @Override
    public void onUpdateUi(List<Song> songList) {
        mAdapter.setListSong(songList);
    }
}
