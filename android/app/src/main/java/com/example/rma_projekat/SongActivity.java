package com.example.rma_projekat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.BaseColumns;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rma_projekat.persistence.song.SongContract;
import com.example.rma_projekat.persistence.song.SongReaderDbHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SongActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable updateSeekBar;
    private MediaPlayer mediaPlayer;
    private SongReaderDbHelper dbHelper;
    private SQLiteDatabase dbRead;
    private SQLiteDatabase dbWrite;
    boolean liked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_song);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String username = getIntent().getStringExtra("username");
        String songName = getIntent().getStringExtra("songName");
        String albumName = getIntent().getStringExtra("albumName");
        String songUrl = getIntent().getStringExtra("songUrl");

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView currentTime = findViewById(R.id.currentTextView);
        TextView totalTime = findViewById(R.id.totalTextView);
        ImageView buttonPlay = findViewById(R.id.buttonPlay);
        ImageView buttonLike = findViewById(R.id.buttonLike);


        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        handler = new Handler(Looper.getMainLooper());
        updateSeekBar = () -> {
            if(mediaPlayer != null && mediaPlayer.isPlaying()){
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                currentTime.setText(formatTime(mediaPlayer.getCurrentPosition()));

                handler.postDelayed(updateSeekBar, 1000);
            }
        };

        mediaPlayer.setOnPreparedListener(mp -> {
            seekBar.setMax(mp.getDuration());
            totalTime.setText(formatTime(mp.getDuration()));
        });

        buttonPlay.setOnClickListener(v ->{
            if(!mediaPlayer.isPlaying()){
                buttonPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
                handler.post(updateSeekBar);
            }
            else{
                buttonPlay.setImageResource(R.drawable.play);
                mediaPlayer.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b && mediaPlayer != null){
                    mediaPlayer.seekTo(i);
                    currentTime.setText(formatTime(i));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        dbHelper = new SongReaderDbHelper(getApplicationContext());
        dbRead = dbHelper.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID
        };

        String selection = SongContract.SongEntry.COLUMN_NAME_NAME + " = ?" + " AND " + SongContract.SongEntry.COLUMN_NAME_USER + " = ?";
        String[] selectionArgs = { songName, username };

        Cursor cursor = dbRead.query(
                SongContract.SongEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if(cursor.getCount() > 0){
            liked = true;
            buttonLike.setImageResource(R.drawable.thumb_up_filled);
        }
        else{
            liked = false;
            buttonLike.setImageResource(R.drawable.thumb_up);
        }

        dbWrite = dbHelper.getWritableDatabase();

        buttonLike.setOnClickListener(v -> {
            if(liked){
                liked = false;
                buttonLike.setImageResource(R.drawable.thumb_up);

                int deletedRows = dbWrite.delete(SongContract.SongEntry.TABLE_NAME, selection, selectionArgs);
            }
            else{
                liked = true;
                buttonLike.setImageResource(R.drawable.thumb_up_filled);

                ContentValues values = new ContentValues();
                values.put(SongContract.SongEntry.COLUMN_NAME_NAME, songName);
                values.put(SongContract.SongEntry.COLUMN_NAME_USER, username);
                values.put(SongContract.SongEntry.COLUMN_NAME_ALBUM, albumName);
                values.put(SongContract.SongEntry.COLUMN_NAME_URL, songUrl);

                long newRowId = dbRead.insert(SongContract.SongEntry.TABLE_NAME, null, values);
            }
        });

        try {
            mediaPlayer.setDataSource(songUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
            handler.post(updateSeekBar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updateSeekBar);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
    private String formatTime(int milliseconds){
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60;

        return String.format("%d:%02d", minutes, seconds);
    }
}