package com.bignerdranch.android.trainerclients.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch.android.trainerclients.database.CustomerDbSchema.CustomerTable;

/**
 * Created by joshuawykell on 10/2/17.
 */

public class CustomerBaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "customerBase.db";

    public CustomerBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(" create table " + CustomerTable.NAME + "(" + " _id integer primary key autoincrement, " +
                CustomerTable.Cols.UUID + ", " +
                CustomerTable.Cols.CUSTOMERNAME + ", " +
                CustomerTable.Cols.EMAIL +", " +
                CustomerTable.Cols.ADDRESS +", " +
                CustomerTable.Cols.PHONE +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
