package com.example.adam.moneycounteralpha;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://www.youtube.com/watch?v=xv_JJbjDQ3M

        // get the data
        SharedPreferences sharedPref = getSharedPreferences("moneyLog", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("total", Integer.toString(13425));
        editor.apply();

        // display the data
        TextView inTextView = findViewById(R.id.inputTextView);
        int num = Integer.parseInt(inTextView.getText().toString());
        TextView outTextView = findViewById(R.id.amountTextView);
        outTextView.setText(String.format("%,d", 1243279654).replace(',', ' '));
    }

    private void submit(View view){

    }
}
