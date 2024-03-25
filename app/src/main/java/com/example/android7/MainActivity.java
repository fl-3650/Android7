package com.example.android7;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent startIntent = new Intent(this, MusicService.class);
        startService(startIntent);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Confirmation");
        builder.setMessage("Sure?");
        builder.setIcon(R.drawable.ic_dialog_alert);

        builder.setPositiveButton("Yes", (dialog, which) -> {

        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent stopIntent = new Intent(this, MusicService.class);
        stopService(stopIntent);
    }
}