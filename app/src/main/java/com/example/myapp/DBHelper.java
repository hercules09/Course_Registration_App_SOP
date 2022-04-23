package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydb.db";
    final static int DBVERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null,DBVERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table regcourses " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "studid text," +
                        "coursename text," +
                        "coursenum text," +
                        "courseinstruc text)"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists regcourses");
        onCreate(sqLiteDatabase);
    }

    public boolean insertCourses(String name,String id, String coursename, String coursenum, String courseinstruc){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("studid", id);
        values.put("coursename", coursename);
        values.put("coursenum", coursenum);
        values.put("courseinstruc", courseinstruc);

        long tableid=database.insert("regcourses",null,values);
        if(tableid<=0){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<registeredcoursesmodel> getCourses(){
        ArrayList<registeredcoursesmodel> registeredcoursesmodel=new ArrayList<>();
        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor= database.rawQuery("Select id,coursename,coursenum,courseinstruc from regcourses",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                registeredcoursesmodel model = new registeredcoursesmodel();
                model.setRegcoursenumber(cursor.getString(0) + "");
                model.setName(cursor.getString(1));
                model.setCourseId(cursor.getString(2));
                model.setCourseInstructor(cursor.getString(3));
                registeredcoursesmodel.add(model);
            }
        }
        cursor.close();
        database.close();
        return registeredcoursesmodel;
    }

    public Cursor getRegCourseById(int id){

        SQLiteDatabase database= this.getWritableDatabase();
        Cursor cursor= database.rawQuery("Select * from regcourses where id ="+ id,null);

        if(cursor!=null)
            cursor.moveToFirst();

        return cursor;
    }
    public boolean updateCourses(String name,String id, String coursename, String coursenum, String courseinstruc){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("studid", id);
        values.put("coursename", coursename);
        values.put("coursenum", coursenum);
        values.put("courseinstruc", courseinstruc);

        long tableid=database.update("regcourses",values,"id="+id,null);
        if(tableid<=0){
            return false;
        }
        else{
            return true;
        }
    }

    public int deleteRegcourses(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("regcourses","id="+id,null);
    }
}
