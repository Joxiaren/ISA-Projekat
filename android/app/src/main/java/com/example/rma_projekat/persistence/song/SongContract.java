package com.example.rma_projekat.persistence.song;

import android.provider.BaseColumns;

public final class SongContract {
    private SongContract() {}

    public static class SongEntry implements BaseColumns{
        public static final String TABLE_NAME = "song";

        public static final String COLUMN_NAME_USER = "username";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_ALBUM = "album";
    }
}
