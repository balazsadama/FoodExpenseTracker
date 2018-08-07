package com.example.adam.moneycounteralpha;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button addItemButton;
    Button deleteItemButton;
    TextView dbContents;
    EditText inputTextView;
    MyDbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://www.youtube.com/watch?v=xv_JJbjDQ3M

        /*// get the data
        SharedPreferences sharedPref = getSharedPreferences("moneyLog", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("total", Integer.toString(13425));
        editor.apply();

        // display the data
        TextView inTextView = findViewById(R.id.inputTextView);
        int num = Integer.parseInt(inTextView.getText().toString());
        TextView outTextView = findViewById(R.id.amountTextView);
        outTextView.setText(String.format("%,d", 1243279654).replace(',', ' '));*/

        dbHandler = new MyDbHandler(this, null, null, 1);
        inputTextView = (EditText) findViewById(R.id.inputText);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        deleteItemButton = (Button) findViewById(R.id.deleteItemButton);
        dbContents = (TextView) findViewById(R.id.dbContents);

        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        dbContents.setText(dbString);
    }

    public void addItemButtonClicked(View view) {
        Expense exp = new Expense(inputTextView.getText().toString(), System.currentTimeMillis());
        dbHandler.addExpense(exp);
        inputTextView.setText("");
        printDatabase();
    }

    public void deleteItemButtonClicked(View view) {
        dbHandler.deleteExpense(inputTextView.getText().toString());
        inputTextView.setText("");
        printDatabase();
    }

    private void submit(View view){

    }
}
