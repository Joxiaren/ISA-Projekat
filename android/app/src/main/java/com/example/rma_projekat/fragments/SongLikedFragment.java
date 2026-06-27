package com.example.rma_projekat.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.BaseColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rma_projekat.R;
import com.example.rma_projekat.SongActivity;
import com.example.rma_projekat.models.Song;
import com.example.rma_projekat.persistence.song.SongContract;
import com.example.rma_projekat.persistence.song.SongReaderDbHelper;

public class SongLikedFragment extends Fragment {

    private ViewGroup scrollContent;
    private SongReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private String url;
    private String username;

    public SongLikedFragment() {
    }
    public static SongLikedFragment newInstance(String username, String url) {
        SongLikedFragment fragment = new SongLikedFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        dbHelper = new SongReaderDbHelper(getContext());
        db = dbHelper.getReadableDatabase();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_liked, container, false);

        Bundle args = getArguments();
        username = args.getString("username");
        url = args.getString("url");
        scrollContent = view.findViewById(R.id.likedScrollContent);

        return view;
    }

    @Override
    public void onResume(){
        Log.i("I have resumed", "Resume");
        scrollContent.removeAllViews();

        LayoutInflater inflater = getLayoutInflater();

        String[] projections = {
                BaseColumns._ID,
                SongContract.SongEntry.COLUMN_NAME_USER,
                SongContract.SongEntry.COLUMN_NAME_NAME,
                SongContract.SongEntry.COLUMN_NAME_ALBUM,
                SongContract.SongEntry.COLUMN_NAME_URL
        };

        String selection = SongContract.SongEntry.COLUMN_NAME_USER + " = ?";
        String[] selectionArgs = { username };

        Cursor cursor = db.query(
                SongContract.SongEntry.TABLE_NAME,
                projections,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        String name;
        String albumName;
        String songUrl;

        while(cursor.moveToNext()){
            View songView = inflater.inflate(R.layout.song_view, scrollContent, false);

            TextView nameTextView = songView.findViewById(R.id.nameTextView);
            TextView albumTextView = songView.findViewById(R.id.albumTextView);
            TextView likeTextView = songView.findViewById(R.id.likesTextView);

            name = cursor.getString(cursor.getColumnIndexOrThrow(SongContract.SongEntry.COLUMN_NAME_NAME));
            albumName = cursor.getString(cursor.getColumnIndexOrThrow(SongContract.SongEntry.COLUMN_NAME_ALBUM));
            songUrl = cursor.getString(cursor.getColumnIndexOrThrow(SongContract.SongEntry.COLUMN_NAME_URL));

            nameTextView.setText(name);
            albumTextView.setText(albumName);
            likeTextView.setText("");

            String finalName = name;
            String finalAlbumName = albumName;
            String finalSongUrl = songUrl;
            songView.setOnClickListener(v -> {
                Bundle b = new Bundle();
                b.putString("songName", finalName);
                b.putString("albumName", finalAlbumName);
                b.putString("songUrl", finalSongUrl);
                b.putString("username", username);

                Intent i = new Intent(v.getContext(), SongActivity.class);
                i.putExtras(b);

                startActivity(i);
            });

            scrollContent.addView(songView);
        }
        super.onResume();
    }
}