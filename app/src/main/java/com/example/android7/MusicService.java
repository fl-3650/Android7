package com.example.android7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    public static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.shadow_wizard_money_gang);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            Log.d(TAG, "Music has started playing");
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d(TAG, "Music has stopped playing");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}