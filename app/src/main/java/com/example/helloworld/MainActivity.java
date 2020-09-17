package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    TextView txtCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtCount = (TextView) findViewById(R.id.textView3);
    }

    public void increment(View view) {
        this.count++;
        this.txtCount.setText(String.valueOf(count));
    }

    public void decrement(View view) {
        this.count--;
        this.txtCount.setText(String.valueOf(count));
    }
}