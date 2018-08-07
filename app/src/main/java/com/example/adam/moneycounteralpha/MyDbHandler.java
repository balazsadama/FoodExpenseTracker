package com.example.adam.moneycounteralpha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class MyDbHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "expenses.db";
    private static final String TABLE_EXPENSES = "expenses";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE = "date";

    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // https://www.youtube.com/watch?v=Jcmp09LkU-I
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_EXPENSES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DATE + " INTEGER " +
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        onCreate(db);
    }

    // Add row to database
    public void addExpense(Expense exp) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        values.put(COLUMN_NAME, exp.get_name());
        values.put(COLUMN_DATE, exp.get_date());
        db.insert(TABLE_EXPENSES, null, values);
        db.close();
    }

    // Delete row from database
    /*public void deleteExpense(int date) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EXPENSES + " WHERE " + COLUMN_DATE + " = \"" + date + "\";");
    }*/
    public void deleteExpense(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EXPENSES + " WHERE " + COLUMN_NAME + " = \"" + name + "\";");
    }


    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "GET * FROM " + TABLE_EXPENSES + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            dbString += c.getString(c.getColumnIndex(COLUMN_NAME)) + " ";
            dbString += c.getString(c.getColumnIndex(COLUMN_DATE)) + "\n";
        }

        return dbString;
    }


}
