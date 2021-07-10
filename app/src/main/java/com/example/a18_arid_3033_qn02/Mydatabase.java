package com.example.a18_arid_3033_qn02;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Mydatabase extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "Billdb";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Data";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Customer Name";
    public static final String COLUMN_NUMBER = "Customer Number";
    public static final String COLUMN_MNUMBER = "Meter Number";
    public static final String COLUMN_AMOUNT = "Pending Amount";
    public static final String COLUMN_LUNIT = "Last Unit";
    public static final String COLUMN_CUNIT = "Current Unit";

    public static final String TABLE_NAME2 = "Register";
    public static final String COLUMN_ID2 = "Id";
    public static final String COLUMN_UNAME = "UserName";
    public static final String COLUMN_PASSWORD = "Password";
    public static final String COLUMN_EMAIL = "Email";

    public Mydatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " +  COLUMN_NUMBER + " INTEGER, " + COLUMN_MNUMBER + " INTEGER, " + COLUMN_AMOUNT
                 + " INTEGER, " + COLUMN_LUNIT + " INTEGER, " + COLUMN_CUNIT + " INTEGER);";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_NAME2 + " (" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_UNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_EMAIL + " TEXT);";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addbill(String name, int number, int mnum, int amount, int lc, int cc){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(COLUMN_NAME, name);
        cn.put(COLUMN_NUMBER, number);
        cn.put(COLUMN_MNUMBER, mnum);
        cn.put(COLUMN_AMOUNT, amount);
        cn.put(COLUMN_LUNIT, lc);
        cn.put(COLUMN_CUNIT, cc);
        long result = mydb.insert(TABLE_NAME,null, cn);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show();
        }
    }
    public void AddUser(String uname, String pass, String mail){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(COLUMN_UNAME, uname);
        cn.put(COLUMN_PASSWORD, pass);
        cn.put(COLUMN_EMAIL, mail);
        long result = mydb.insert(TABLE_NAME2,null, cn);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successfully Registered", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void login(String name, String pass){
        String query = "SELECT * FROM " + TABLE_NAME2 + " WHERE " + COLUMN_UNAME + " == '" + name + "';";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query, null);
            if(cursor.getString(2) == pass){
                Toast.makeText(context, "Successfully Login", Toast.LENGTH_SHORT).show();
                Intent inte = new Intent(this, MainActivity.class);
                startActivity(inte);
            }
            else {
                Toast.makeText(context, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
            }
        }
        return cursor;
    }
}
