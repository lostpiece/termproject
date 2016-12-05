package com.example.ensu4.termproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {


    private static final String DB_NAME="schedule.db";


    private static final int DATABASE_VERSION = 1;




    public DataBase(Context context) {


        super(context, DB_NAME, null, DATABASE_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE schedule (" +
                "_id INTEGER  NOT NULL PRIMARY KEY," +
                "name TEXT NULL"+
                "day DATETIME  NULL," +
                        "start DATETIME  NULL,"+
                        "end DATETIME  NULL,"+
                        "lot TEXT NULL"+
                        "memo TEXT NULL"+
                        "mutilmedia DATA NULL"+
                "datetime DATETIME  NULL" +
                ");");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS schedule");
        onCreate(db);
    }

}
