package com.example.fattrni;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.view.View;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="database.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String qry= "create table user (id integer primary key autoincrement,username text,password text,country text,email text,phone text)";
      db.execSQL(qry);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }
    //inserting in database
    public  boolean insert(String u ,String p,String c, String e,String ph)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",u);
        contentValues.put("password",p);
        contentValues.put("country",c);
        contentValues.put("email",e);
        contentValues.put("phone",ph);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)
        return false;
        else
            return true ;

    }
    //check if username and password exists
    public boolean check(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from user where username=? and password = ?",new String[]{username,password} );
        if(cursor.getCount()>0)
            return  true;
        else
            return  false;

    }
}
