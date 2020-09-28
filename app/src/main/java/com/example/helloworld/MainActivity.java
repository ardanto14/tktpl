package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    TextView txtCount;
    SimpleCalculator calc;
    EditText editTextA;
    EditText editTextB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtCount = (TextView) findViewById(R.id.textView3);

        calc = new SimpleCalculator();

        editTextA=findViewById(R.id.editA);
        editTextB=findViewById(R.id.editB);

    }

    public void add(View view) {

        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();

        this.txtCount.setText(Integer.toString(calc.add(Integer.parseInt(textA), Integer.parseInt(textB))));
    }

    public void sub(View view) {
        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();

        this.txtCount.setText(Integer.toString(calc.sub(Integer.parseInt(textA), Integer.parseInt(textB))));
    }

    public void mult(View view) {
        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();

        this.txtCount.setText(Integer.toString(calc.mult(Integer.parseInt(textA), Integer.parseInt(textB))));
    }

    public void div(View view) {

        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();

        this.txtCount.setText(Integer.toString(calc.div(Integer.parseInt(textA), Integer.parseInt(textB))));
    }
}