package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    TextView txtCount;
    Button increment_button;
    Button decrement_button;

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtCount = (TextView) findViewById(R.id.textView3);



        Log.v("test", stringFromJNI());

        this.increment_button = findViewById(R.id.increment);
        this.decrement_button = findViewById(R.id.decrement);

        View.OnClickListener inc = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                count = increment(count);
                txtCount.setText(Integer.toString(count));
            }
        };

        increment_button.setOnClickListener(inc);

        View.OnClickListener dec = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                count = decrement(count);
                txtCount.setText(Integer.toString(count));
            }
        };

        decrement_button.setOnClickListener(dec);


    }

    public native String stringFromJNI();

    public native int increment(int x);

    public native int decrement(int x);


}