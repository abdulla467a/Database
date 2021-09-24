package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String database_name ="studentsdb";
    public  String studentInfo_Table_Name ="studentInfo";
    public  String student_coloumn_id = "id ";
    public  String student_coloumn_name = "name";
    public  String student_coloumn_email = "email";
    public  String student_coloumn_phone = "phone";


    public DatabaseHelper(Context context) {
        super(context,database_name,null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE studentInfo "+"(id integer primary key autoincrement,name text,email text,phone text)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS studentInfo");
        onCreate(db);
    }
    public String addStudentsInfo(String nameText,String phoneText,String emailText){

        ContentValues mycontent = new ContentValues();
        mycontent.put("name",nameText);
        mycontent.put("email",emailText);
        mycontent.put("phone",phoneText);
        SQLiteDatabase mydb=this.getWritableDatabase();
        mydb.insert("studentInfo",null,mycontent);
        mydb.close();
        return "Y";
    }
}
