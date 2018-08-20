package com.example.ba.demomvp.main;

import com.example.ba.demomvp.data.entity.Song;

import java.util.List;

public interface MainContract {
    interface View {
        void onUpdateUi(List<Song> songList);
    }

    interface Present {
        void loadDataSongs();

        int countSongs();

        Song getItemSong(int positon);
    }
}
