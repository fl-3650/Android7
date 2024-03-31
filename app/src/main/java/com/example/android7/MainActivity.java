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
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ...

        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            this.year = year;
            this.month = month;
            this.day = dayOfMonth;

            TimePickerDialog.OnTimeSetListener timeSetListener = (view1, hourOfDay, minute1) -> {
                this.hour = hourOfDay;
                this.minute = minute1;

                String date = String.format("%02d-%02d-%04d", day, month + 1, year);
                String time = String.format("%02d:%02d", hour, minute);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("date", date);
                intent.putExtra("time", time);
                startActivity(intent);
            };

            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener, 0, 0, false);
            timePickerDialog.show();
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, year, month, day);
        datePickerDialog.show();
    }

    // ...
}