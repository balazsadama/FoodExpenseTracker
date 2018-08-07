package com.example.adam.moneycounteralpha;

import java.util.Date;

public class Expense {
    private int _id;
    private String _name;
    private long _date;

    public Expense(String _name, long _date) {
        this._name = _name;
        this._date = _date;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public long get_date() {
        return _date;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_date(int _date) {
        this._date = _date;
    }
}
