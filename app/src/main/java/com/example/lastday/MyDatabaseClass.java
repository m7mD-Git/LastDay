package com.example.lastday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="DBNAME.db";
    private static final String TABLE_NAME ="Student";
    private static final String COL_ID  ="id";
    private static final String COL_NAME ="name";
    private static final String COL_ADDRESS ="address";

    private static final int DB_VERSION = 2;


    public MyDatabaseClass(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        /*sqLiteDatabase.execSQL("create table Student (id integer primary key autoincrement , name " +
                "text not null , address text not null)");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        /*sqLiteDatabase.execSQL("Drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);*/

    }

    public long insert(String st_name, String st_address){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME,st_name);
        values.put(COL_ADDRESS,st_address);

        long row = db.insert(TABLE_NAME,null,values);

        db.close();

       /* if(row != -1)
            return true;
        else
            return  false;*/
        return row;

    }

    public int update(int id , String st_name, String st_address){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME,st_name);
        values.put(COL_ADDRESS,st_address);

        int row = db.update(TABLE_NAME,values,COL_ID+" = "+id,null);

        db.close();
        return row;

    }

    public int delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        int row = db.delete(TABLE_NAME,COL_ID+" = "+id,null);
        db.close();
        return row;

    }

    public Cursor getStudent(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_NAME,new String [] {COL_ID,COL_NAME,COL_ADDRESS},COL_ID+" = "+id,
                null,null,null,null);

        if(c!=null)
            c.moveToFirst();

        return c;

    }

    public Cursor getAllStudent(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_NAME,new String [] {COL_ID,COL_NAME,COL_ADDRESS},null,
                null,null,null,null);

        if(c!=null)
            c.moveToFirst();

        return c;

    }
}
