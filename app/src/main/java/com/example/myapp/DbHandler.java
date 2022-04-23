package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    public static final String DBNAME = "myapp.db";
    public static final String TABLENAME ="details";
    public static final int VER=1;

    // table and db name declaration

//    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)version

    public DbHandler(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }
    // default

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query = "create table "+TABLENAME+" (roomname text  , avatar blob)";
//      String query = "create table"+TABLENAME+"(roomid integer primary key , roomname text , avatar blob)";
    db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query =  "drop table if exists "+TABLENAME;
        db.execSQL(query);
    }

    // insert data

    public boolean insertData( String name , byte[] img) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("roomname" , name);
        contentValues.put("avatar" , img);
        long ins = MyDB.insert( TABLENAME , null , contentValues);
        if (ins == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // retrive name Working code

    public String getName(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLENAME+" where roomname = ?", new String[]{new String(name)});
        cursor.moveToFirst();

        return cursor.getString(0);

    }
    // retrive image NOT Working code

    public Bitmap getImage(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from "+TABLENAME+" where roomname = ?", new String[]{new String(name)});
        cursor.moveToFirst();
        byte[] bitmap = cursor.getBlob(0);
        Bitmap image = BitmapFactory.decodeByteArray(bitmap , 0 , bitmap.length);
        return image;
    }
}
