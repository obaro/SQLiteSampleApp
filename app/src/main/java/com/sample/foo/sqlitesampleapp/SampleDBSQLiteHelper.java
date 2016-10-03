package com.sample.foo.sqlitesampleapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by obaro on 26/09/2016.
 */

public class SampleDBSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sample_database";

    public SampleDBSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SampleDBContract.Employer.CREATE_TABLE);
        sqLiteDatabase.execSQL(SampleDBContract.Employee.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Employer.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Employee.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
