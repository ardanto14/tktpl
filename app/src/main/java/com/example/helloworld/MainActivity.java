package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ListFragment fragment = new ListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, fragment, "ListFragment")
                    .commit();
        }
    }

    public void showInfo() {
        DetailsFragment fragment = new DetailsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment, "DetailsFragment")
                .addToBackStack("DetailsFragment")
                .commit();
    }

}