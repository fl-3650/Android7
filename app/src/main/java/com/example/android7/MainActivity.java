package com.example.android7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent startIntent = new Intent(this, MusicService.class);
        startService(startIntent);

        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {

        };

        DatePickerDialog datePickerDialog = new DatePickerDialog
                (MainActivity.this, dateSetListener, year, month, day);

        datePickerDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent stopIntent = new Intent(this, MusicService.class);
        stopService(stopIntent);
    }
}