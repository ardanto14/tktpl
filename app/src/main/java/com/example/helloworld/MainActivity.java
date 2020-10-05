package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView txtCount;
    int seconds, milliseconds, minutes;

    long startTime, msTime, accTime, timeBuffer;

    Handler handler;

    public Runnable runnable = new Runnable() {
        @Override

        public void run()
        {
            msTime = SystemClock.uptimeMillis() - startTime;

            accTime = timeBuffer + msTime;

            seconds = (int) (accTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliseconds = (int) (accTime % 1000);


            // Set the text view text.
            txtCount.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliseconds));

            // Post the code again
            // with a delay of 1 second.
            handler.postDelayed(this, 0);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtCount = (TextView) findViewById(R.id.textView3);

        startTime = SystemClock.uptimeMillis();


        handler = new Handler();
    }


    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        new AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Exit Application")
            .setMessage("Are you sure you want to close this application?")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }

            })
            .setNegativeButton("No", null)
            .show();
    }

    public void start(View view) {
        startTime = SystemClock.uptimeMillis();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(runnable);
    }

    public void stop(View view) {
        timeBuffer += msTime;
        handler.removeCallbacks(runnable);
    }

    public void reset(View view) {
        seconds = 0;
        minutes = 0;
        milliseconds = 0;
        accTime = 0;
        timeBuffer = 0;
        msTime = 0;
        startTime = 0;

        txtCount.setText("0:00:000");

        handler.removeCallbacks(runnable);
    }
}