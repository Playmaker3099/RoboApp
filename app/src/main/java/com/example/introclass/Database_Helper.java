package com.example.introclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper
{
    private static final String Database_Name = "RoboDB";
    private static  final int Database_Version = 1;

    /*
    Drop the table if it exist
    * Create Table RoboTab(
    * RoboID int,
    * RoboNAME varchar(50),
    * )
    *
    * We're going to mimic the SQL structure in java */
    private static final String Table_Robot = "robtab"; //robtab = robot + table
    private static final String Column_ID = "id";
    private static final String Column_Name = "roboName";

    public Database_Helper(Context context)
    {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + Table_Robot + "(" +
                Column_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " + Column_Name + "TEXT" + ");";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Robot);
        onCreate(db);
    }

    //insert record
    public boolean insertRecord(String name)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_Name, name);

        long result = sqLiteDatabase.insert(Table_Robot, null, contentValues);

        return result != -1;
    }
}
