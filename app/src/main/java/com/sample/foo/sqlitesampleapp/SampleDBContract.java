package com.sample.foo.sqlitesampleapp;

import android.provider.BaseColumns;



/**
 * Created by obaro on 26/09/2016.
 */

public final class SampleDBContract {

    public static final String SELECT_EMPLOYEE_WITH_EMPLOYER = "SELECT * " +
            "FROM " + Employee.TABLE_NAME + " ee INNER JOIN " + Employer.TABLE_NAME + " er " +
            "ON ee." + Employee.COLUMN_EMPLOYER_ID + " = er." + Employer._ID + " WHERE " +
            "ee." + Employee.COLUMN_FIRSTNAME + " like ? AND ee." + Employee.COLUMN_LASTNAME + " like ?";

    private SampleDBContract() {
    }

    public static class Employer implements BaseColumns {
        public static final String TABLE_NAME = "employer";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_FOUNDED_DATE = "date";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_FOUNDED_DATE + " INTEGER" + ")";
    }

    public static class Employee implements BaseColumns {
        public static final String TABLE_NAME = "employee";
        public static final String COLUMN_FIRSTNAME = "firstname";
        public static final String COLUMN_LASTNAME = "lastname";
        public static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
        public static final String COLUMN_EMPLOYER_ID = "employer_id";
        public static final String COLUMN_JOB_DESCRIPTION = "job_description";
        public static final String COLUMN_EMPLOYED_DATE = "employed_date";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRSTNAME + " TEXT, " +
                COLUMN_LASTNAME + " TEXT, " +
                COLUMN_DATE_OF_BIRTH + " INTEGER, " +
                COLUMN_EMPLOYER_ID + " INTEGER, " +
                COLUMN_JOB_DESCRIPTION + " TEXT, " +
                COLUMN_EMPLOYED_DATE + " INTEGER, " +
                "FOREIGN KEY(" + COLUMN_EMPLOYER_ID + ") REFERENCES " +
                Employer.TABLE_NAME + "(" + Employer._ID + ") " + ")";

    }
}
